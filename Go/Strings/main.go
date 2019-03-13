package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(strings.Compare("sss", "vvv"))
	fmt.Println(strings.Compare("vvv", "vvv"))
	fmt.Println(strings.Count("vvv", "v"))
	fmt.Println(strings.Join([]string{"ssss", "aaaa"}, ","))
}
