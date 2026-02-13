# RSS Scraper

A Python script that reads RSS URLs from a file, fetches the feeds, and stores the data in PostgreSQL. Designed to be run as a cron job.

## Features

- Reads RSS URLs from a configuration file
- Parses RSS feeds using feedparser
- Stores title, URL, and publication date in PostgreSQL
- Handles duplicate entries gracefully
- Comprehensive logging
- Cron-compatible wrapper script

## Setup

### Prerequisites

- Python 3.6+
- PostgreSQL database
- Internet connection to fetch RSS feeds

### Installation

1. **Clone the repository or copy the files:**
   ```bash
   git clone https://github.com/your-repo/rss-scraper.git
   cd rss-scraper
   ```

2. **Set up configuration:**
   - Copy `config.ini.example` to `config.ini`
   - Copy `rss_urls.txt.example` to `rss_urls.txt`
   - Edit both files with your database credentials and RSS URLs

3. **Install dependencies:**
   ```bash
   pip install -r requirements.txt
   ```
   Or use the wrapper script which handles this automatically:
   ```bash
   ./run_rss_scraper.sh
   ```

### Database Setup

The script will automatically create the `rss_items` table if it doesn't exist. The table structure includes:

- `id`: Primary key
- `title`: Article title
- `url`: Article URL (unique)
- `published_date`: Publication date
- `feed_url`: Source RSS feed URL
- `created_at`: When the record was created
- `updated_at`: When the record was last updated

## Usage

### Manual Execution

```bash
python rss_scraper.py
```

### Cron Job Setup

To run the scraper automatically, add it to your crontab:

```bash
# Edit crontab
crontab -e

# Add this line to run every hour
0 * * * * /path/to/rss-scraper/run_rss_scraper.sh >> /path/to/rss-scraper/cron.log 2>&1
```

### Using the Wrapper Script

The `run_rss_scraper.sh` script handles:
- Virtual environment creation
- Dependency installation
- Environment setup
- Script execution

```bash
./run_rss_scraper.sh
```

## Configuration

### config.ini

```ini
# Database configuration
DB_HOST=localhost
DB_PORT=5432
DB_NAME=rss_scraper
DB_USER=your_username
DB_PASSWORD=your_password

# RSS URLs file
RSS_URLS_FILE=rss_urls.txt
```

### rss_urls.txt

```txt
# Add one RSS URL per line
https://example.com/rss.xml
https://another-example.com/feed.xml
```

## Logging

The script logs to both console and `rss_scraper.log` file. Logs include:
- Timestamps
- Information about processed feeds
- Error messages
- Database operations

## Error Handling

The script handles:
- Missing configuration files
- Database connection failures
- RSS parsing errors
- Duplicate entries
- Network issues

## Customization

You can customize:
- Logging level by modifying the logging configuration
- Database schema by editing the table creation SQL
- RSS parsing logic in the `_parse_rss_feed` method
- Error handling and retry logic

## License

MIT License - feel free to use and modify as needed.
