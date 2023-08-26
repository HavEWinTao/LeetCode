package main

import (
	"fmt"
	"sort"
)

// 两个长度为n的数组a、b，一个整数m
// 现在可以重新排列a，是否可以让a满足1<=a_i+b_i<=m
func main() {
	var T int
	fmt.Scan(&T)
	for i := 0; i < T; i++ {
		fn()
	}
}

func fn() {
	var n, m int
	fmt.Scan(&n, &m)
	a := make([]int, n)
	b := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}
	for i := 0; i < n; i++ {
		fmt.Scan(&b[i])
	}
	sort.Ints(b)
	sort.Ints(a)
	for i := 0; i < n; i++ {
		if b[i]+a[n-1-i] < 1 || b[i]+a[n-1-i] > m {
			fmt.Println("No")
			return
		}
	}
	fmt.Println("Yes")
}
