package main

import "fmt"

func scope() func() int {
	val := 2
	foo := func() int { return val }
	return foo
}

func main() {
	function := scope()
	fmt.Printf("%d", function())
}
