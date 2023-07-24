package main

import "fmt"

func trap(height []int) int {
	var ret int
	stack := make([]int, 0)
	for i, v := range height {
		for len(stack) != 0 && height[stack[len(stack)-1]] < v {
			top := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			if len(stack) > 0 {
				ret += (minInt(height[stack[len(stack)-1]], v) - height[top]) * (i - stack[len(stack)-1] - 1)
			}
		}
		stack = append(stack, i)
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
	height := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	//height := []int{4, 2, 0, 3, 2, 5}
	fmt.Println(trap(height))
}
