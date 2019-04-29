package main

import (
	"context"
	"github.com/docker/docker/api/types"
	"github.com/docker/docker/client"
	"os"
)

func main() {

	os.Setenv("DOCKER_API_VERSION", "1.39")
	cli, err := client.NewClientWithOpts(client.FromEnv)
	if err != nil {
		panic(err)
	}

	r, err := os.Open("/Users/pawel.ma/ubuntu.tar")
	if err != nil {
		panic(err)
	}

	source := types.ImageImportSource{Source: r, SourceName: "-"}

	opts := types.ImageImportOptions{Tag: "latest", Message: "dupa"}

	_, err = cli.ImageImport(context.Background(), source, "", opts)

	if err != nil {
		panic(err)
	}

}
