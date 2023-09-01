package main

import "fmt"

// LIS O(N^2)解法
func LIS(arr []int) int {
	if len(arr) == 0 {
		return 0
	}
	dp := make([]int, len(arr))
	for i := 0; i < len(dp); i++ {
		dp[i] = 1
	}
	ans := 1
	for i := 0; i < len(arr); i++ {
		for j := 0; j < i; j++ {
			if arr[i] > arr[j] && dp[i] < dp[j]+1 {
				dp[i] = dp[j] + 1
				ans = maxInt(ans, dp[i])
			}
		}
	}
	return ans
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	{
		nums := []int{6, 3, 1, 5, 2, 3, 7}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{3, 5, 7, 1, 2, 4, 6, 3, 8, 9, 5, 6}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
	//单调栈：错误解法，处理不来这种情况
	{
		nums := []int{1, 2, 3, 4, 3, 5}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
}
