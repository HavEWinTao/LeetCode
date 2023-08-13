package main

import "math"

func minFallingPathSum(grid [][]int) int {
	n := len(grid)
	dp := make([][]int, n, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n, n)
		for j := 0; j < n; j++ {
			dp[i][j] = math.MaxInt
		}
	}
	for i := 0; i < n; i++ {
		dp[0][i] = grid[0][i]
	}
	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			for k := 0; k < n; k++ {
				if k != j {
					dp[i][j] = minInt(dp[i][j], dp[i-1][k]+grid[i][j])
				}
			}
		}
	}
	ret := math.MaxInt
	for i := 0; i < n; i++ {
		ret = minInt(ret, dp[n-1][i])
	}
	return ret
}

func minFallingPathSum1(grid [][]int) int {
	n := len(grid)
	firstMinSum, secondMinSum := 0, 0
	firstMinIndex := -1
	for i := 0; i < n; i++ {
		curFirstMinSum, curSecondMinSum := math.MaxInt, math.MaxInt
		curFirstMinIndex := -1
		for j := 0; j < n; j++ {
			curSum := grid[i][j]
			if j != firstMinIndex {
				curSum += firstMinSum
			} else {
				curSum += secondMinSum
			}
			if curSum < curFirstMinSum {
				curSecondMinSum, curFirstMinSum = curFirstMinSum, curSum
				curFirstMinIndex = j
			} else if curSum < curSecondMinSum {
				curSecondMinSum = curSum
			}
		}
		firstMinSum, secondMinSum = curFirstMinSum, curSecondMinSum
		firstMinIndex = curFirstMinIndex
	}
	return firstMinSum
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}
