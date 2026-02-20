# AGENTS.md - KitchenSink Vibe Project

## Project Overview

This is the **KitchenSink/vibe** repository - a collection of miscellaneous code samples and scripts. The primary component in this directory is an **RSS Scraper** written in Python 3 that fetches RSS feeds and stores them in PostgreSQL.

## Repository Structure

```
vibe/
└── rss-scrape/
    ├── rss_scraper.py       # Main Python script
    ├── run_rss_scraper.sh   # Wrapper script with venv setup
    ├── config.ini.example   # Configuration template
    ├── rss_urls.txt.example # RSS URLs template
    ├── requirements.txt     # Python dependencies
    └── README.md            # Documentation
```

## Build, Lint, and Test Commands

### Running the RSS Scraper

```bash
# Direct execution (requires dependencies installed)
python3 rss_scraper.py

# Using the wrapper script (auto-creates venv)
./run_rss_scraper.sh
```

### Dependencies

Install manually:
```bash
pip install -r requirements.txt
```

Required packages (from requirements.txt):
- `feedparser==6.0.10` - RSS/Atom feed parsing
- `psycopg2-binary==2.9.9` - PostgreSQL database adapter

### Testing

**There are no formal tests in this project.** To test manually:
1. Set up a PostgreSQL database
2. Copy `config.ini.example` to `config.ini` and configure
3. Copy `rss_urls.txt.example` to `rss_urls.txt` with test URLs
4. Run the scraper and verify entries in the database

### Linting

**No formal linter is configured.** For code quality, consider:
```bash
# Install pylint or ruff
pip install pylint ruff

# Run pylint
pylint rss_scraper.py

# Or ruff (faster)
ruff check rss_scraper.py
```

---

## Code Style Guidelines

### General Philosophy

This codebase follows **PEP 8** with some additional conventions. When modifying existing code, match the current style. When adding new code, follow these guidelines.

### Imports

```python
# Standard library first, then third-party, then local
import os
import sys
import time
import feedparser
import psycopg2
from psycopg2 import sql
from datetime import datetime
from typing import List, Dict, Optional
import logging
```

- Use absolute imports
- Group imports by type (stdlib, third-party, local)
- Sort alphabetically within groups
- Use `from X import Y` for specific items, `import X` for modules

### Formatting

- **Line length**: Maximum 100 characters (soft limit at 120)
- **Indentation**: 4 spaces (no tabs)
- **Blank lines**: Two blank lines between top-level definitions, one between methods
- **Trailing whitespace**: Remove all trailing whitespace

```python
class RSSScraper:
    def __init__(self, config_file: str = 'config.ini'):
        """Initialize the RSS scraper with configuration."""
        self.config_file = config_file
        self.config = self._load_config()
        self.db_connection = None
    
    def _load_config(self) -> Dict:
        """Load configuration from file."""
        # Implementation
```

### Types

- Use type hints for function signatures and variables
- Prefer concrete types over `Any`
- Use `Optional[X]` instead of `X | None` for Python 3.9 compatibility

```python
def _read_rss_urls(self) -> List[str]:
    """Read RSS URLs from file."""
    # ...

def _parse_rss_feed(self, url: str) -> List[Dict]:
    # ...
```

### Naming Conventions

| Element | Convention | Example |
|---------|------------|---------|
| Classes | PascalCase | `RSSScraper` |
| Functions/methods | snake_case | `_load_config`, `run` |
| Variables | snake_case | `config_file`, `db_connection` |
| Private methods | leading underscore | `_get_db_connection` |
| Constants | UPPER_SNAKE_CASE | `DB_HOST`, `DB_PORT` |
| Files | snake_case | `rss_scraper.py` |

### Docstrings

Use Google-style docstrings with triple quotes:

```python
def _load_config(self) -> Dict:
    """Load configuration from file.
    
    Returns:
        Dict: Configuration key-value pairs.
    
    Raises:
        FileNotFoundError: If config file doesn't exist.
        ValueError: If required config keys are missing.
    """
```

### Error Handling

- Use specific exception types
- Always log errors with meaningful context
- Use `sys.exit(1)` for fatal errors that should stop the script
- Rollback database transactions on errors

```python
try:
    with open(self.config_file, 'r') as f:
        # Process file
except FileNotFoundError:
    logger.error(f"Config file {self.config_file} not found")
    sys.exit(1)
except Exception as e:
    logger.error(f"Error loading config: {e}")
    sys.exit(1)
```

### Database Operations

- Use context managers (`with`) for cursors and connections
- Always commit after successful operations
- Rollback on errors before exiting
- Close connections in `finally` blocks

```python
def _create_table_if_not_exists(self):
    """Create the rss_items table if it doesn't exist."""
    conn = self._get_db_connection()
    try:
        with conn.cursor() as cursor:
            cursor.execute("""...""")
            conn.commit()
    except Exception as e:
        logger.error(f"Error creating table: {e}")
        conn.rollback()
        sys.exit(1)
```

### Logging

- Use the `logging` module, not print statements
- Configure handlers for both file and console
- Use appropriate log levels: DEBUG, INFO, WARNING, ERROR, CRITICAL

```python
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(levelname)s - %(message)s',
    handlers=[
        logging.FileHandler('rss_scraper.log'),
        logging.StreamHandler()
    ]
)
logger = logging.getLogger(__name__)
```

### String Formatting

- Use f-strings for simple interpolation
- Use `.format()` for complex formatting
- Use `psycopg2.sql` for SQL queries with user input

```python
# Simple f-string
logger.info(f"Loaded {len(urls)} RSS URLs from {urls_file}")

# SQL with parameterization
cursor.execute("""
    SELECT id FROM rss_items WHERE url = %s
""", (item['url'],))
```

---

## Configuration Files

### config.ini Format

```ini
DB_HOST=localhost
DB_PORT=5432
DB_NAME=rss_scraper
DB_USER=your_username
DB_PASSWORD=your_password
RSS_URLS_FILE=rss_urls.txt
```

### rss_urls.txt Format

One URL per line, lines starting with `#` are comments:
```
# Tech news
https://example.com/tech/rss.xml
https://news.example.com/feed.xml
```

---

## Common Tasks

### Adding a new RSS field

1. Edit `_parse_rss_feed()` to extract the new field
2. Update `_store_rss_items()` to include the field
3. Add column to the CREATE TABLE SQL
4. Test with a feed that includes the new field

### Changing database schema

1. Modify the CREATE TABLE statement in `_create_table_if_not_exists()`
2. For existing databases, manually run ALTER TABLE

### Adding a new dependency

1. Add to `requirements.txt` with version pin
2. Update README.md if it's a required dependency
3. Test the script works with the new dependency
