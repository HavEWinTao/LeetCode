package main

import "fmt"

func rotate(matrix [][]int) [][]int {
	size := len(matrix)
	for i := 0; i < size; i++ {
		for j := i; j < size-i-1; j++ {
			x := i
			y := j
			pre := matrix[x][y]
			for k := 0; k < 4; k++ {
				x, y = y, size-1-x
				matrix[x][y], pre = pre, matrix[x][y]
			}
		}
	}
	return matrix
}

func main() {
	{
		matrix := [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
		ret := rotate(matrix)
		fmt.Printf("%+v\n", ret)
	}
	{
		matrix := [][]int{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}
		ret := (matrix)
		fmt.Printf("%+v\n", ret)
	}
}
