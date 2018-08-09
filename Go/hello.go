package main

import (
	"closure"
	"fmt"
	"funct"
	"maps"
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
}
