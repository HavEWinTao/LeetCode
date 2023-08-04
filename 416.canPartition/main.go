package main

import "fmt"

func canPartition(nums []int) bool {
	sum := 0
	for _, v := range nums {
		sum += v
	}
	if sum%2 != 0 {
		return false
	}
	n := sum / 2
	var dfs func(int, int) bool
	cache := make([][]int, len(nums), len(nums))
	for i := 0; i < len(nums); i++ {
		cache[i] = make([]int, n+1)
		for j := 0; j <= n; j++ {
			cache[i][j] = -1
		}
	}
	dfs = func(i, c int) (ret bool) {
		if i < 0 {
			return c == 0
		}
		if cache[i][c] != -1 {
			return cache[i][c] == 1
		}
		defer func() {
			if ret {
				cache[i][c] = 1
			} else {
				cache[i][c] = 2
			}
		}()
		if nums[i] > c {
			return dfs(i-1, c)
		}
		return dfs(i-1, c) || dfs(i-1, c-nums[i])
	}
	ret := dfs(len(nums)-1, n)
	return ret
}

func main() {
	{
		nums := []int{1, 5, 11, 5}
		ret := canPartition(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{1, 2, 3, 5}
		ret := canPartition(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{66, 90, 7, 6, 32, 16, 2, 78, 69, 88, 85, 26, 3, 9, 58, 65, 30, 96, 11, 31, 99, 49, 63, 83, 79, 97, 20, 64, 81, 80, 25, 69, 9, 75, 23, 70, 26, 71, 25, 54, 1, 40, 41, 82, 32, 10, 26, 33, 50, 71, 5, 91, 59, 96, 9, 15, 46, 70, 26, 32, 49, 35, 80, 21, 34, 95, 51, 66, 17, 71, 28, 88, 46, 21, 31, 71, 42, 2, 98, 96, 40, 65, 92, 43, 68, 14, 98, 38, 13, 77, 14, 13, 60, 79, 52, 46, 9, 13, 25, 8}
		ret := canPartition(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{2, 2, 1, 1}
		ret := canPartition(nums)
		fmt.Printf("%+v\n", ret)
	}
}
