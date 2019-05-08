package main

import "fmt"

type abc struct {
	a int
}

func do(i interface{}) {
	switch v := i.(type) {
	case int:
		fmt.Printf("INT %s\n", v)
	case abc:
		fmt.Printf("ABC %s\n", v)
	default:
		fmt.Printf("Other %s\n", v)
	}
}

func main() {
	do(10)
	do("sss")
	do(abc{a: 10})
}
