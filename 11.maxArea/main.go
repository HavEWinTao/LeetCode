package main

import "fmt"

func maxArea(height []int) int {
	i := 0
	j := len(height) - 1
	ret := -1
	for i < j {
		ret = maxInt(ret, minInt(height[i], height[j])*(j-i))
		if height[i] < height[j] {
			i++
		} else {
			j--
		}
	}
	return ret
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func minInt(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func main() {
	height := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	ret := maxArea(height)
	fmt.Printf("%+v\n", ret)
}
