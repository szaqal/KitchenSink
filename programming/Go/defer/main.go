package main

import (
	"fmt"
	"time"
)

func closeAll() {
	fmt.Println("Closed")
}

func doWait(c chan int) {
	time.Sleep(1 * time.Second)
	c <- 1
}

func main() {

	defer closeAll()

	c := make(chan int)
	go doWait(c)
	<-c
	fmt.Println("Done")
}
