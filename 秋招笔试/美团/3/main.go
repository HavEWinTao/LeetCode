package main

import (
	"fmt"
	"sort"
)

// 一个长度为n的数组a，可以操作k次
// 每次操作可以选两个下标i,j，令x*y=a_i*a_j，用x,y代替a_i,a_j
// 求操作k次后数组和的最大值
func main() {
	fn()
}

func fn() {
	mod := int64(1000000000 + 7)
	var n, k int
	fmt.Scan(&n, &k)
	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}
	sort.Ints(a)
	var mul int64 = 1
	for i := 0; i <= k; i++ {
		mul = (mul * int64(a[n-1-i])) % mod
	}
	ans := (mul + int64(k)) % mod
	for i := k + 1; i < n; i++ {
		ans = (ans + int64(a[n-1-i])) % mod
	}
	fmt.Println(ans)
}
