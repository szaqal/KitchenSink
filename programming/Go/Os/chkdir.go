package main

import (
	"log"
	"os"
)

func main() {
	err := os.Chdir("/tmp/1")

	if err != nil {
		log.Fatal(err)
		//Fatal level is effectively logging the message, then calling os.Exit(1).
		os.Exit(100)
	}
}
