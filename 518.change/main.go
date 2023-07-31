package main

import "fmt"

func change(amount int, coins []int) int {
	n := len(coins)
	cache := make([][]int, n, n)
	for i := 0; i < n; i++ {
		cache[i] = make([]int, amount+1, amount+1)
		for j := 0; j <= amount; j++ {
			cache[i][j] = -1
		}
	}
	var dfs func(int, int) int
	dfs = func(i, c int) (res int) {
		if i < 0 {
			if c == 0 {
				return 1
			}
			return 0
		}
		if cache[i][c] != -1 {
			return cache[i][c]
		}
		defer func() { cache[i][c] = res }()
		if coins[i] > c {
			return dfs(i-1, c)
		}
		return dfs(i-1, c) + dfs(i, c-coins[i]) //多少种方案
	}
	return dfs(n-1, amount)
}

func main() {
	{
		amount := 5
		coins := []int{1, 2, 5}
		ret := change(amount, coins)
		fmt.Printf("%+v\n", ret)
	}
	{
		amount := 3
		coins := []int{2}
		ret := change(amount, coins)
		fmt.Printf("%+v\n", ret)
	}
}
