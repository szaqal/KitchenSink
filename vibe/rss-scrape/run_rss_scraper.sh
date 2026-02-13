#!/bin/bash

# RSS Scraper Cron Wrapper Script
# This script sets up the environment and runs the RSS scraper

# Set the working directory to the script location
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR" || exit 1

# Set up Python environment
PYTHON_BIN="python3"

# Check if Python is available
if ! command -v "$PYTHON_BIN" &> /dev/null; then
    echo "Error: Python3 not found"
    exit 1
fi

# Check if virtual environment exists, if not create it
if [ ! -d "venv" ]; then
    echo "Creating virtual environment..."
    "$PYTHON_BIN" -m venv venv
    if [ $? -ne 0 ]; then
        echo "Error: Failed to create virtual environment"
        exit 1
    fi
fi

# Activate virtual environment
source venv/bin/activate

# Install dependencies if not already installed
if [ ! -f "requirements_installed" ]; then
    echo "Installing dependencies..."
    pip install -r requirements.txt
    if [ $? -eq 0 ]; then
        touch requirements_installed
    else
        echo "Error: Failed to install dependencies"
        deactivate
        exit 1
    fi
fi

# Run the RSS scraper
echo "Running RSS scraper..."
python rss_scraper.py

# Deactivate virtual environment
deactivate

echo "RSS scraper completed"
