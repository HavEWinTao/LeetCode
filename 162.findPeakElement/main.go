package main

import (
	"fmt"
	"math"
)

func findPeakElement(nums []int) int {
	n := len(nums)
	i := 0
	j := n - 1
	var get func(idx int) int
	get = func(idx int) int {
		if idx == -1 || idx == n {
			return math.MinInt
		}
		return nums[idx]
	}
	for {
		mid := (i + j) / 2
		if get(mid) > get(mid-1) && get(mid) > get(mid+1) {
			return mid
		}
		if get(mid) < get(mid+1) {
			i = mid + 1
		} else {
			j = mid - 1
		}
	}
}

func main() {
	{
		nums := []int{1, 2, 3, 1}
		ret := findPeakElement(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{1, 2, 1, 3, 5, 6, 4}
		ret := findPeakElement(nums)
		fmt.Printf("%+v\n", ret)
	}
}
