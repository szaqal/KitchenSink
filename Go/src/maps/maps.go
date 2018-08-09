package maps

import "fmt"

func DummyMaps() {
	m := make(map[string]int)
	m["k1"] = 7
	m["k2"] = 1
	fmt.Println(m)
	delete(m, "k2")
	_, prs := m["k2"]
	fmt.Println("prs:", prs)
}
