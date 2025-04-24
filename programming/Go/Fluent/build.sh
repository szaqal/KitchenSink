#!/bin/bash
go build -ldflags "-X main.Build=$(git rev-parse --short HEAD)"

