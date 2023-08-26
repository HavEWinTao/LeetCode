package main

import "fmt"

// 输入：一个数组，长度为n；一个数，k
// 求最长连续子数组满足子数组的平均数为k，输出长度
func main() {
	var n, k int
	fmt.Scan(&n, &k)
	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
		a[i] -= k
	}
	mp := make(map[int]int)
	ans := -1
	sum := 0
	for i := 0; i < n; i++ {
		sum += a[i]
		if sum == 0 {
			ans = maxInt(ans, i+1)
			continue
		}
		v, ok := mp[sum]
		if !ok {
			mp[sum] = i
		} else {
			ans = maxInt(ans, i-v)
		}
	}
	fmt.Println(ans)
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
