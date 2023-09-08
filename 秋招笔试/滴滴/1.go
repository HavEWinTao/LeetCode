package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scan(&n)
	var a, b int
	fmt.Scan(&a, &b)
	c := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&c[i])
	}
	ans := sort.Search(10000, func(day int) bool { //好多0，本地代码忘改了
		sum := 0
		for i := 0; i < n; i++ {
			sum += day * c[i] / b
		}
		return sum >= a
	})
	fmt.Println(ans)
}
