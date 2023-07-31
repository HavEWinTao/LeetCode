package main

import (
	"fmt"
)

const mod = 1000000007

func waysToChange(n int) int {
	coins := []int{25, 10, 5, 1}
	numsLen := len(coins)
	cache := make([][]int, numsLen, numsLen)
	for i := 0; i < numsLen; i++ {
		cache[i] = make([]int, n+1, n+1)
		{
			for j := 0; j <= n; j++ {
				cache[i][j] = -1
			}
		}
	}
	var dfs func(int, int) int
	dfs = func(i int, c int) (res int) {
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
		if c < coins[i] {
			return dfs(i-1, c) % mod
		}
		return (dfs(i-1, c) + dfs(i, c-coins[i])) % mod // 总共多少种方案
	}
	return dfs(numsLen-1, n)
}

func waysToChange1(n int) int {
	dp := make([]int, n+1)
	dp[0] = 1
	coins := []int{1, 5, 10, 25}
	for i := 0; i < 4; i++ {
		for j := 1; j <= n; j++ {
			if j-coins[i] >= 0 {
				dp[j] = (dp[j] + dp[j-coins[i]]) % mod
			}
		}
	}
	return dp[n] % mod
}

func main() {
	fmt.Printf("%d\n", waysToChange(10))
	fmt.Printf("%d\n", waysToChange(5))
	fmt.Printf("%d\n", waysToChange(25))
	fmt.Printf("%d\n", waysToChange(50))
	fmt.Printf("%d\n", waysToChange(100))
}
