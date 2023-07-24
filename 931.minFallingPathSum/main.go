package main

import (
	"fmt"
	"math"
)

func minFallingPathSum(matrix [][]int) int {
	n := len(matrix)
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, n)
		dp[0][i] = matrix[0][i]
	}
	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			dp[i][j] = calMin(dp, matrix, i, j)
		}
	}
	var ret int
	ret = math.MaxInt
	for i := 0; i < n; i++ {
		ret = minInt(ret, dp[n-1][i])
	}
	return ret
}

func calMin(dp, matrix [][]int, i, j int) int {
	n := len(matrix)
	ids := make([]int, 0, 3)
	ids = append(ids, j)
	if j-1 >= 0 {
		ids = append(ids, j-1)
	}
	if j+1 < n {
		ids = append(ids, j+1)
	}
	var ret int
	ret = math.MaxInt
	for _, k := range ids {
		ret = minInt(ret, dp[i-1][k]+matrix[i][j])
	}
	return ret
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	matrix := [][]int{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}
	fmt.Println(minFallingPathSum(matrix))
}
