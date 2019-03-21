package main

import (
	"bufio"
	"fmt"
	"net"
)

func main() {
	conn, err := net.Dial("tcp", "poczta.interia.pl:25")
	if err != nil {
		panic(err)
	}
	fmt.Fprintf(conn, "HELO abc\n")
	status, err := bufio.NewReader(conn).ReadString('\n')
	fmt.Println(status)
}
