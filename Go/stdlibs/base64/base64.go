package main

import (
	"encoding/base64"
	"fmt"
	"os"
)

func main() {
	// newEncoding func
	// StdEncoding field
	enc := base64.NewEncoder(base64.StdEncoding, os.Stdout)
	i, err := enc.Write([]byte("test"))

	if err != nil {
		os.Exit(10)
	}

	enc.Close()

	fmt.Println()
	fmt.Println(int(i))
}
