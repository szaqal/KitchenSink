package main

import (
	"fmt"
	"net"
)

func main() {
	ip := net.ParseIP("192.168.1.3")
	fmt.Println(ip)
	ipAddr := net.IPAddr{IP: ip}
	fmt.Println(ipAddr)
	fmt.Println(ipAddr.Network())
}
