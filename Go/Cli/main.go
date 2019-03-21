package main

import (
	"github.com/mitchellh/cli"
	"log"
	"os"
)

//https://github.com/mitchellh/cli/blob/master/command.go
type ServerCommand struct {
	Message string
}

func (c *ServerCommand) Help() string {
	return c.Message
}

func (c *ServerCommand) Synopsis() string {
	return c.Message
}

func (c *ServerCommand) Run(_ []string) int {
	return 0
}

func main() {
	c := cli.NewCLI("app", "1.0")
	c.Args = os.Args[1:]

	c.Commands = map[string]cli.CommandFactory{
		"foo": func() (cli.Command, error) {
			return &ServerCommand{Message: "test"}, nil
		},
	}

	exitStatus, err := c.Run()
	if err != nil {
		log.Println(err)
	}
	os.Exit(exitStatus)
}
