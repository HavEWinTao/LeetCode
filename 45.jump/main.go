package main

import "fmt"

func jump(nums []int) int {
	n := len(nums)
	dp := make([]int, n, n)

	for i, v := range nums {
		for j := 1; j <= v && i+j < n; j++ {
			if dp[i+j] != 0 {
				dp[i+j] = minInt(dp[i+j], dp[i]+1)
			} else {
				dp[i+j] = dp[i] + 1
			}
		}
	}
	return dp[n-1]
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	{
		nums := []int{2, 3, 1, 1, 4}
		fmt.Printf("%+v\n", jump(nums))
	}
	{
		nums := []int{2, 3, 0, 1, 4}
		fmt.Printf("%+v\n", jump(nums))
	}
}
