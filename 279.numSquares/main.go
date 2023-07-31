package main

import (
	"fmt"
	"math"
)

func numSquares(n int) int {
	sqrt := int(math.Sqrt(float64(n)))
	cache := make([][]int, sqrt+1, sqrt+1)
	for i := 0; i <= sqrt; i++ {
		cache[i] = make([]int, n+1, n+1)
		for j := 0; j <= n; j++ {
			cache[i][j] = -1
		}
	}
	var dfs func(int, int) int
	dfs = func(i int, c int) (res int) {
		if i == 0 {
			if c == 0 {
				return 0
			}
			return math.MaxInt / 2
		}
		if cache[i][c] != -1 {
			return cache[i][c]
		}
		defer func() { cache[i][c] = res }()
		pow := i * i
		if pow > c {
			return dfs(i-1, c)
		}
		return minInt(dfs(i-1, c), dfs(i, c-pow)+1) // 最少要多少件物品
	}
	return dfs(sqrt, n)
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	{
		n := 12
		ret := numSquares(n)
		fmt.Printf("%+v\n", ret)
	}
	{
		n := 13
		ret := numSquares(n)
		fmt.Printf("%+v\n", ret)
	}
}
