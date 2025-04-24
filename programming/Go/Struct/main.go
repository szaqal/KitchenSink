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

	// empty struct
	y := Rect{}
	fmt.Println(y)

	// with pointers
	z := new(Rect)
	fmt.Println(z)
	z.x = 10
	fmt.Println(z)

}
