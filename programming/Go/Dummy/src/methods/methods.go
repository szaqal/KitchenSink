package methods

type Rect struct {
	Height, Width int
}

func (r Rect) Area() int {
	return r.Width * r.Height
}
