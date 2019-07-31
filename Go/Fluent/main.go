package main

import "fmt"

var Build string

type Dupa struct {
	name string
}

func NewDupa() *Dupa {
	return &Dupa{name: "new"}
}

func (d *Dupa) set(name string) *Dupa {
	d.name = name
	return d
}

func (d *Dupa) get() string {
	return d.name
}

func main() {
	fmt.Println("Using build:", Build)
	fmt.Print("Hi:", NewDupa().set("xxx").get())
}
