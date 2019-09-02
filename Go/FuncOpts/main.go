package main

import "fmt"

func main() {
	fmt.Println("vim-go")
	configure(
		withConfA("a"),
		withConfB("b"),
	)
}

type Config struct {
	confA string
	confB string
}

type ConfigOpt func(*Config)

func withConfA(confA string) ConfigOpt {
	return func(cfg *Config) {
		cfg.confA = confA
	}
}

func withConfB(confB string) ConfigOpt {
	return func(cfg *Config) {
		cfg.confB = confB
	}
}

func configure(opts ...ConfigOpt) {
	cfg := new(Config)
	for _, fn := range opts {
		fn(cfg)
	}
}
