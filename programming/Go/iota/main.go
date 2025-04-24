package main

import "fmt"

const (
	IsJava = 1 << iota
	IsDocker
	IsGo
)

func main() {
	fmt.Println(IsJava | IsDocker)
	fmt.Println(IsJava & IsDocker)
}
