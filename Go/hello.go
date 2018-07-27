package main

import "fmt"

var (
	x int
	y string
)

func main() {
	x := 10
	y := "xxx"
	fmt.Printf("Hello %d, %s", x, y)

	//----

	list := []string{"a", "b", "c", "d"}
	for k, v := range list {
		fmt.Printf("%s %s\n", k, v)
	}

	//-----
	a := [...]int{1, 2, 3, 4, 5}
	fmt.Printf("=> %s\n", a[2:3])

	print()

	zzz := func(x int) {
		fmt.Printf("\n Callback: %d", x)
	}
	callback(10, zzz)
}

func print() {
	fmt.Printf("\nfuncssssssss")
}

func callback(y int, f func(int)) {
	f(y)
}
