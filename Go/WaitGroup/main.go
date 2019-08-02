package main

import (
	"fmt"
	"sync"
	"time"
)

func worker(id int, wg *sync.WaitGroup) {
	time.Sleep(time.Second)
	fmt.Printf("%d done\n", id)
	wg.Done()
}

func main() {
	var wg sync.WaitGroup

	for i := 1; i < 5; i++ {
		//If the counter becomes zero, all goroutines blocked on Wait are released
		wg.Add(1)
		go worker(i, &wg)
	}
	wg.Wait()

}
