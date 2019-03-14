package main

import (
	"fmt"
)

func gen(c chan int) {
	for i := 0; i < 10; i++ {
		c <- i
	}
	close(c)
}

func main() {
	c := make(chan int, 10)
	go gen(c)

	for i := range c {
		fmt.Println(i)
	}

}
