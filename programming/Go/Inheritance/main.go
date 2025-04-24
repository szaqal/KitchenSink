package main

import (
	"fmt"
)

type Operate interface {
	Compute() int
}

type Add struct {
	in1, in2 int
}

func (a *Add) Compute() int {
	return a.in1 + a.in2
}

type Sub struct {
	in1, in2 int
}

func (s *Sub) Compute() int {
	return s.in1 - s.in2
}

// INTEFACE METHOD HERE !!
func Compute(o Operate) int {
	return o.Compute()
}

func main() {
	a := &Add{1, 2}
	fmt.Println(Compute(a))

	s := &Sub{1, 2}
	fmt.Println(Compute(s))
}
