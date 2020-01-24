package main

import (
	"io"
	"log"
	"net"
)

func main() {

	listener, _ := net.Listen("tcp", "127.0.0.1:3000")
	defer listener.Close()
	for {
		// Wait for a connection.
		conn, err := listener.Accept()
		if err != nil {
			log.Fatal(err)
		}
		go func(c net.Conn) {
			io.Copy(c, c)
			c.Close()
		}(conn)
	}
}
