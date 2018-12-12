package main

import (
	"fmt"
	"os"
	"text/template"
)

type Context struct {
	Name    string
	Version string
}

func simple() {
	td := Context{"Name", "1.0"}

	t, err := template.New("abc").Parse("\"{{ .Name }}              \" => \"              {{ .Version }}\"")
	err = t.Execute(os.Stdout, td)
	if err != nil {
		panic(err)
	}

}

func trim() {
	td := Context{"Name", "1.0"}
	t1, err := template.New("abc1").Parse("\"{{ .Name -}}             \" => \"            {{- .Version }}\"")
	err = t1.Execute(os.Stdout, td)
	if err != nil {
		panic(err)
	}
}

func multipline() {
	td := Context{"Name", "1.0"}
	templateVal := `
	 {{ .Name }}
	 {{ .Version }}
	`

	t1, err := template.New("abc1").Parse(templateVal)
	err = t1.Execute(os.Stdout, td)
	if err != nil {
		panic(err)
	}
}

func expr() {
	td := Context{"Name", "1.0"}
	templateVal := `
	 {{if (ne "" .Name)}}
	 	NOT EMPTY
	 {{else}}
	 	EMPTY
	 {{end }}
	`
	t1, err := template.New("abc1").Parse(templateVal)
	err = t1.Execute(os.Stdout, td)
	if err != nil {
		panic(err)
	}
}

func main() {

	simple()
	fmt.Println("\n TRIM \n")

	trim()
	fmt.Println("\n MULTILINE \n")

	multipline()
	fmt.Println("\n EXPR \n")
	expr()

}
