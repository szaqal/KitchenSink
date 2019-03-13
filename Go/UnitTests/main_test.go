package main

import "testing"

func Test(t *testing.T) {
	got := Hello()
	want := "Hello World"

	if got != want {
		t.Errorf("Error")
	}
}
