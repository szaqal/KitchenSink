package closure

func TestClosure() func() string {
	res := "hello world"
	return func() string {
		return res
	}
}
