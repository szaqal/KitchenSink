#!/bin/bash

# Build the Go program
echo "Building AtomicCounter..."
go build -o AtomicCounter main.go

# Check if build succeeded
if [ $? -ne 0 ]; then
    echo "Build failed"
    exit 1
fi

# Run the program
echo "Running AtomicCounter..."
./AtomicCounter

# Clean up
rm -f AtomicCounter
