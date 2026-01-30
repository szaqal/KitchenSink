#!/bin/bash

# Build the Go program
echo "Building Http..."
go build -o Http main.go

# Check if build succeeded
if [ $? -ne 0 ]; then
    echo "Build failed"
    exit 1
fi

# Run the program
echo "Running Http..."
./Http

# Clean up
rm -f Http
