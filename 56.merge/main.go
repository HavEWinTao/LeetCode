package main

import (
	"fmt"
	"sort"
)

func merge(intervals [][]int) [][]int {
	n := len(intervals)
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][0] != intervals[j][0] {
			return intervals[i][0] < intervals[j][0]
		}
		return intervals[i][1] > intervals[j][1]
	})
	idx := 0
	ans := make([][]int, 0)
	for idx < n {
		left := intervals[idx][0]
		right := intervals[idx][1]
		for idx < n && intervals[idx][0] <= right {
			right = maxInt(right, intervals[idx][1])
			idx++
		}
		ans = append(ans, []int{left, right})
	}
	return ans
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	{
		intervals := [][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}
		ret := merge(intervals)
		fmt.Printf("%+v\n", ret)
	}
	{
		intervals := [][]int{{1, 4}, {4, 5}}
		ret := merge(intervals)
		fmt.Printf("%+v\n", ret)
	}
}
