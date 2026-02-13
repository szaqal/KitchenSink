#!/usr/bin/env python3
"""
RSS Scraper Script

This script reads URLs from a file, fetches RSS feeds, and stores the data in PostgreSQL.
Designed to be run as a cron job.
"""

import os
import sys
import time
import feedparser
import psycopg2
from psycopg2 import sql
from datetime import datetime
from typing import List, Dict, Optional
import logging

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('rss_scraper.log'),
        logging.StreamHandler()
    ]
)
logger = logging.getLogger(__name__)


class RSSScraper:
    def __init__(self, config_file: str = 'config.ini'):
        """Initialize the RSS scraper with configuration."""
        self.config_file = config_file
        self.config = self._load_config()
        self.db_connection = None
        
    def _load_config(self) -> Dict:
        """Load configuration from file."""
        config = {}
        try:
            with open(self.config_file, 'r') as f:
                for line in f:
                    line = line.strip()
                    if line and not line.startswith('#'):
                        key, value = line.split('=', 1)
                        config[key.strip()] = value.strip()
            
            # Validate required config
            required_keys = ['DB_HOST', 'DB_PORT', 'DB_NAME', 'DB_USER', 'DB_PASSWORD', 'RSS_URLS_FILE']
            for key in required_keys:
                if key not in config:
                    raise ValueError(f"Missing required config: {key}")
            
            return config
        except FileNotFoundError:
            logger.error(f"Config file {self.config_file} not found")
            sys.exit(1)
        except Exception as e:
            logger.error(f"Error loading config: {e}")
            sys.exit(1)

    def _get_db_connection(self):
        """Establish database connection."""
        if self.db_connection is None or self.db_connection.closed:
            try:
                self.db_connection = psycopg2.connect(
                    host=self.config['DB_HOST'],
                    port=self.config['DB_PORT'],
                    dbname=self.config['DB_NAME'],
                    user=self.config['DB_USER'],
                    password=self.config['DB_PASSWORD']
                )
                logger.info("Database connection established")
            except Exception as e:
                logger.error(f"Database connection failed: {e}")
                sys.exit(1)
        return self.db_connection

    def _create_table_if_not_exists(self):
        """Create the rss_items table if it doesn't exist."""
        conn = self._get_db_connection()
        try:
            with conn.cursor() as cursor:
                cursor.execute("""
                    CREATE TABLE IF NOT EXISTS rss_items (
                        id SERIAL PRIMARY KEY,
                        title TEXT NOT NULL,
                        url TEXT NOT NULL UNIQUE,
                        published_date TIMESTAMP,
                        feed_url TEXT NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    )
                """)
                conn.commit()
                logger.info("Table rss_items is ready")
        except Exception as e:
            logger.error(f"Error creating table: {e}")
            conn.rollback()
            sys.exit(1)

    def _read_rss_urls(self) -> List[str]:
        """Read RSS URLs from file."""
        urls_file = self.config['RSS_URLS_FILE']
        try:
            with open(urls_file, 'r') as f:
                urls = [line.strip() for line in f if line.strip() and not line.startswith('#')]
            logger.info(f"Loaded {len(urls)} RSS URLs from {urls_file}")
            return urls
        except FileNotFoundError:
            logger.error(f"RSS URLs file {urls_file} not found")
            sys.exit(1)
        except Exception as e:
            logger.error(f"Error reading RSS URLs: {e}")
            sys.exit(1)

    def _parse_rss_feed(self, url: str) -> List[Dict]:
        """Parse RSS feed and extract items."""
        try:
            feed = feedparser.parse(url)
            items = []
            
            for entry in feed.entries:
                # Extract published date, handle different formats
                published_date = None
                if hasattr(entry, 'published_parsed'):
                    published_date = datetime(*entry.published_parsed[:6])
                elif hasattr(entry, 'updated_parsed'):
                    published_date = datetime(*entry.updated_parsed[:6])
                
                items.append({
                    'title': entry.title if hasattr(entry, 'title') else 'No title',
                    'url': entry.link if hasattr(entry, 'link') else url,
                    'published_date': published_date,
                    'feed_url': url
                })
            
            logger.info(f"Parsed {len(items)} items from {url}")
            return items
        except Exception as e:
            logger.error(f"Error parsing RSS feed {url}: {e}")
            return []

    def _store_rss_items(self, items: List[Dict]):
        """Store RSS items in database."""
        if not items:
            return
            
        conn = self._get_db_connection()
        try:
            with conn.cursor() as cursor:
                for item in items:
                    try:
                        # Check if URL already exists
                        cursor.execute("""
                            SELECT id FROM rss_items WHERE url = %s
                        """, (item['url'],))
                        
                        if cursor.fetchone():
                            # Update existing record
                            cursor.execute("""
                                UPDATE rss_items 
                                SET title = %s, published_date = %s, updated_at = CURRENT_TIMESTAMP
                                WHERE url = %s
                            """, (item['title'], item['published_date'], item['url']))
                            logger.debug(f"Updated existing item: {item['title']}")
                        else:
                            # Insert new record
                            cursor.execute("""
                                INSERT INTO rss_items (title, url, published_date, feed_url)
                                VALUES (%s, %s, %s, %s)
                            """, (item['title'], item['url'], item['published_date'], item['feed_url']))
                            logger.info(f"Inserted new item: {item['title']}")
                    except Exception as e:
                        logger.error(f"Error storing item {item.get('title', 'unknown')}: {e}")
                        conn.rollback()
                        continue
                
                conn.commit()
                logger.info(f"Successfully stored {len(items)} items")
        except Exception as e:
            logger.error(f"Database error: {e}")
            conn.rollback()
            sys.exit(1)

    def run(self):
        """Main execution method."""
        logger.info("Starting RSS scraper")
        
        start_time = time.time()
        
        try:
            # Initialize database
            self._create_table_if_not_exists()
            
            # Read RSS URLs
            rss_urls = self._read_rss_urls()
            
            # Process each RSS feed
            for url in rss_urls:
                items = self._parse_rss_feed(url)
                self._store_rss_items(items)
                
            end_time = time.time()
            logger.info(f"RSS scraper completed in {end_time - start_time:.2f} seconds")
            
        except Exception as e:
            logger.error(f"Unexpected error: {e}")
            sys.exit(1)
        finally:
            if self.db_connection and not self.db_connection.closed:
                self.db_connection.close()
                logger.info("Database connection closed")


if __name__ == "__main__":
    scraper = RSSScraper()
    scraper.run()
