package main

import "fmt"

/*
正数的和 p
整个数组的和 sum
负数的和 sum-p
p-(s-p) = target
p = (s+t)/2
*/
func findTargetSumWays(nums []int, target int) int {
	sum := 0
	for _, v := range nums {
		sum += v
	}
	target += sum
	if target < 0 || target%2 == 1 {
		return 0
	}
	target /= 2

	n := len(nums)
	cache := make([][]int, n, n)

	var dfs func(int, int) int
	dfs = func(i, c int) (res int) {
		if i < 0 {
			if c == 0 {
				return 1
			} else {
				return 0
			}
		}
		if cache[i][c] != -1 {
			return cache[i][c]
		}
		defer func() { cache[i][c] = res }()
		if c < nums[i] {
			return dfs(i-1, c)
		}
		return dfs(i-1, c) + dfs(i-1, c-nums[i]) //多少种方案
	}

	for i := 0; i < n; i++ {
		cache[i] = make([]int, target+1, target+1)
		for j := 0; j <= target; j++ {
			cache[i][j] = -1
		}
	}
	return dfs(n-1, target)
}

func findTargetSumWays1(nums []int, target int) int {
	sum := 0
	for _, v := range nums {
		sum += v
	}
	target += sum
	if target < 0 || target%2 == 1 {
		return 0
	}
	target /= 2
	n := len(nums)
	f := make([][]int, n+1, n+1)
	for i := range f {
		f[i] = make([]int, target+1, target+1)
	}
	f[0][0] = 1
	for i := 0; i < n; i++ {
		x := nums[i]
		for c := 0; c <= target; c++ {
			if c < x {
				f[i+1][c] = f[i][c]
			} else {
				f[i+1][c] = f[i][c] + f[i][c-x]
			}
		}
	}
	return f[n][target]
}

func main() {
	nums := []int{1, 1, 1, 1, 1}
	target := 3
	ret := findTargetSumWays(nums, target)
	fmt.Printf("%+v\n", ret)
	ret = findTargetSumWays1(nums, target)
	fmt.Printf("%+v\n", ret)
}
