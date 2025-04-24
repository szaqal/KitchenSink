package main

import (
	"crypto/sha1"
	"fmt"
)

func main() {
	hh := sha1.New()
	fmt.Printf("%x", hh.Sum([]byte("abcdd")))
}
