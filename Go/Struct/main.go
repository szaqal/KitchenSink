package main

import (
	"fmt"
)

type Rect struct {
	x int
	y int
}

func main() {
	x := Rect{10, 20}
	fmt.Println(x)
	fmt.Println(x.x)
}
