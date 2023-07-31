package main

import "fmt"

func rob(nums []int) int {
	n := len(nums)
	dp := make([][]int, n, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, 2, 2)
	}
	dp[0][0] = 0
	dp[0][1] = nums[0]
	for i := 1; i < n; i++ {
		dp[i][0] = maxInt(dp[i-1][0], dp[i-1][1])
		dp[i][1] = dp[i-1][0] + nums[i]
	}
	return maxInt(dp[n-1][0], dp[n-1][1])
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	{
		nums := []int{2, 7, 9, 3, 1}
		ret := rob(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{1, 2, 3, 1}
		ret := rob(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{2, 1, 1, 2}
		ret := rob(nums)
		fmt.Printf("%+v\n", ret)
	}
}
