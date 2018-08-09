package slices

import "fmt"

func DummySlices() {
	// The make function allocates a zeroed array
	s := make([]string, 3)
	fmt.Println("emp:", s)

	s[0] = "a"
	s[1] = "b"
	fmt.Println("set:", s)

	l := s[1:2]
	fmt.Println("set:", l)
}
