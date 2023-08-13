package main

func diagonalSum(mat [][]int) int {
	n := len(mat)
	ret := 0
	for i := 0; i < n; i++ {
		ret += mat[i][i]
		if i != n-1-i {
			ret += mat[i][n-1-i]
		}
	}
	return ret
}
