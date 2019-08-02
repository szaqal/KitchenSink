package main

import (
	"fmt"
	"time"
)

func main() {
	//func After(d Duration) <-chan Time
	<-time.After(1 * time.Second)
	fmt.Println("Timer 1 expired")
}
