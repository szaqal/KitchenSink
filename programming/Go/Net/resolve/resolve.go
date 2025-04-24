package main

import (
	"fmt"
	"net"
)

func main() {
	addr, err := net.LookupHost("onet.pl")
	if err != nil {
		panic(err)
	}

	fmt.Println(addr)
}
