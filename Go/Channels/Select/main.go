package main

import "fmt"

func handle(c, quit chan int) {
	for {
		select {
		case c <- 1:
			fmt.Println("ok")
		case <-quit:
			fmt.Println("Done")
			return
		}
	}
}

func main() {
	c := make(chan int)
	quit := make(chan int)
	go func() {
		for i := 0; i < 5; i++ {
			<-c
		}
		quit <- 0
	}()
	handle(c, quit)
}
