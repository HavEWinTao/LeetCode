package main

import "math"

func maxProfit(prices []int) int {
	minPrice := math.MaxInt
	ans := 0
	for _, v := range prices {
		if v < minPrice {
			minPrice = v
		} else if (v - minPrice) > ans {
			ans = v - minPrice
		}
	}
	return ans
}
