package main

import (
	"context"
	"fmt"
	"time"
)

func xxxx(ctx context.Context) {
	fmt.Println("Wait")
	select {
	case <-ctx.Done():
		fmt.Print("Cancel received")
	}
}

func main() {
	ctx := context.Background()
	ctx, cancel := context.WithCancel(ctx)
	fmt.Println("start")
	go func() {
		<-time.After(1 * time.Second)
		cancel()
	}()
	xxxx(ctx)
}
