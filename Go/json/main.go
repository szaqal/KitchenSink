package main

import (
	"encoding/json"
	"fmt"
)

type Data struct {
	A string `json:"aa"`
	B string `json:"ba"`
}

func main() {

	data := &Data{
		A: "aaa",
		B: "bbb",
	}

	z, _ := json.Marshal(data)
	fmt.Println(string(z))
}
