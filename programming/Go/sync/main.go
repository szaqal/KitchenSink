package main

import (
	"fmt"
	"sync"
	"time"
)

type AtomicInt struct {
	n  int
	mu sync.Mutex
}

func (a *AtomicInt) Add(n int) {
	a.mu.Lock()
	a.n += n
	a.mu.Unlock()
}

func (a *AtomicInt) Value() int {
	a.mu.Lock()
	n := a.n
	a.mu.Unlock()
	return n
}

func main() {
	wait := make(chan struct{})

	var n AtomicInt
	go func() {
		<-time.After(1 * time.Second)
		n.Add(1)
		close(wait)
	}()
	n.Add(1)
	<-wait
	fmt.Println(n.Value())
}
