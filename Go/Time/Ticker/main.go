package main

import (
	"fmt"
	"time"
)

func main() {
	ticker := time.NewTicker(500 * time.Millisecond)
	go func() {
		for t := range ticker.C {
			fmt.Println(t)
		}
	}()

	time.Sleep(2000 * time.Millisecond)
	ticker.Stop()

}
