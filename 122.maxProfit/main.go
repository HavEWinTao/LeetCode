package main

import "fmt"

func maxProfit(prices []int) int {
	n := len(prices)
	dp := make([][2]int, n)
	//0表示当天没有股票
	//1表示当天有股票
	dp[0][1] = -prices[0]
	for i := 1; i < n; i++ {
		dp[i][0] = maxInt(dp[i-1][0], dp[i-1][1]+prices[i])
		dp[i][1] = maxInt(dp[i-1][1], dp[i-1][0]-prices[i])
	}
	return dp[n-1][0]
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	{
		prices := []int{7, 1, 5, 3, 6, 4}
		ret := maxProfit(prices)
		fmt.Printf("%+v\n", ret)
	}
	{
		prices := []int{1, 2, 3, 4, 5}
		ret := maxProfit(prices)
		fmt.Printf("%+v\n", ret)
	}
	{
		prices := []int{7, 6, 4, 3, 1}
		ret := maxProfit(prices)
		fmt.Printf("%+v\n", ret)
	}
}
