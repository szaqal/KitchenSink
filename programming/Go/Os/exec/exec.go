package main

import (
	"fmt"
	"os/exec"
)

func main() {
	cmd := exec.Command("ls", "-la", "/tmp")

	out, _ := cmd.CombinedOutput()
	fmt.Println(fmt.Errorf("Output: %s", out))
}
