package main

import (
	"closure"
	"fmt"
	"funct"
	"maps"
	"methods"
	"ptrs"
	"slices"
)

func main() {
	slices.DummySlices()
	maps.DummyMaps()

	// multivalue returns
	_, b := funct.Dupa()
	fmt.Println("Result ", b)

	// closures
	fmt.Println("result ", closure.TestClosure()())

	// pointers
	i := 1
	fmt.Println("result ", ptrs.PtrTest(&i))

	//mehods
	r := methods.Rect{Width: 10, Height: 10}
	fmt.Println("result ", r.Area())
}
