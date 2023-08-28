package main

import "fmt"

type Guai struct {
	x, y, h, a, b int
}

func main() {
	var n, H int
	fmt.Scan(&n, &H)
	var guai1, guai2 Guai
	fmt.Scan(&guai1.x, &guai1.y, &guai1.h, &guai1.a, &guai1.b)
	fmt.Scan(&guai2.x, &guai2.y, &guai2.h, &guai2.a, &guai2.b)
	ans := -1
	ans = maxInt(ans, fn(H, guai1, guai2))
	ans = maxInt(ans, fn(H, guai2, guai1))
	if ans == -1 {
		fmt.Println("yingyingying")
		return
	}
	fmt.Println(ans)
}

func fn(H int, guai1, guai2 Guai) int {
	step1 := guai1.x + guai1.y - 2
	step2 := step1 + absInt(guai2.x-guai1.x) + absInt(guai2.y-guai1.y)
	guai1.h += step1 / guai1.a * guai1.b
	guai2.h += (step2 + 1) / guai2.a * guai2.b
	if H-guai1.h < 0 {
		return -1
	}
	H -= guai1.h
	if H-guai2.h < 0 {
		return -1
	}
	H -= guai2.h
	return H
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func absInt(num int) int {
	if num < 0 {
		return -num
	}
	return num
}
