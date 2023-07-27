package main

import "sort"

func deleteGreatestValue(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	for _, v := range grid {
		sort.Ints(v)
	}
	ret := 0
	for i := n - 1; i >= 0; i-- {
		temp := 0
		for j := 0; j < m; j++ {
			temp = maxInt(temp, grid[j][i])
		}
		ret += temp
	}
	return ret
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
