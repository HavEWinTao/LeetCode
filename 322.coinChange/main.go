package main

import (
	"fmt"
	"math"
)

func coinChange(coins []int, amount int) int {
	n := len(coins)
	cache := make([][]int, n, n)
	for i := 0; i < n; i++ {
		cache[i] = make([]int, amount+1, amount+1)
		for j := 0; j <= amount; j++ {
			cache[i][j] = -1
		}
	}
	var dfs func(int, int) int
	dfs = func(i, c int) (ret int) {
		if i < 0 {
			if c == 0 {
				return 0
			}
			return math.MaxInt / 2
		}
		if cache[i][c] != -1 {
			return cache[i][c]
		}
		defer func() { cache[i][c] = ret }()
		if c < coins[i] {
			return dfs(i-1, c)
		}
		return minInt(dfs(i-1, c), dfs(i, c-coins[i])+1) // 最少要多少件物品
	}
	ret := dfs(n-1, amount)
	if ret < math.MaxInt/2 {
		return ret
	}
	return -1
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	{
		coins := []int{1, 2, 5}
		amount := 11
		ret := coinChange(coins, amount)
		fmt.Printf("%+v\n", ret)
	}
	{
		coins := []int{2}
		amount := 3
		ret := coinChange(coins, amount)
		fmt.Printf("%+v\n", ret)
	}
	{
		coins := []int{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}
		amount := 9864
		ret := coinChange(coins, amount)
		fmt.Printf("%+v\n", ret)
	}
}
