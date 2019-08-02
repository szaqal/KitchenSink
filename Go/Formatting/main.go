package main

import "fmt"

type Dupa struct {
	abc string
	zzz int
}

func main() {
	d := Dupa{abc: "sss", zzz: 10}
	fmt.Printf("%v\n", d)
	fmt.Printf("%+v\n", d)
	fmt.Printf("%#v\n", d)
	fmt.Printf("%T\n", d)

}
