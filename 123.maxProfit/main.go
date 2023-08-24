package main

import "math"

func maxProfit(prices []int) int {
	n := len(prices)
	dp := make([][4]int, n)
	dp[0][0] = -prices[0]
	dp[0][1] = math.MinInt / 2
	dp[0][2] = math.MinInt / 2
	dp[0][3] = math.MinInt / 2
	for i := 1; i < n; i++ {
		dp[i][0] = maxInt(dp[i-1][0], -prices[i])
		dp[i][1] = maxInt(dp[i-1][1], dp[i-1][0]+prices[i])
		dp[i][2] = maxInt(dp[i-1][2], dp[i-1][1]-prices[i])
		dp[i][3] = maxInt(dp[i-1][3], dp[i-1][2]+prices[i])
	}
	return maxInt(0, maxInt(dp[n-1][1], dp[n-1][3]))
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
