package main

import (
	"fmt"
)

func insert(intervals [][]int, newInterval []int) (ans [][]int) {
	left, right := newInterval[0], newInterval[1]
	merged := false
	for _, interval := range intervals {
		if interval[0] > right {
			// 在插入区间的右侧且无交集
			if !merged {
				ans = append(ans, []int{left, right})
				merged = true
			}
			ans = append(ans, interval)
		} else if interval[1] < left {
			// 在插入区间的左侧且无交集
			ans = append(ans, interval)
		} else {
			// 与插入区间有交集，计算它们的并集
			left = minInt(left, interval[0])
			right = maxInt(right, interval[1])
		}
	}
	if !merged {
		ans = append(ans, []int{left, right})
	}
	return
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	{
		intervals := [][]int{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}
		newInterval := []int{4, 8}
		ret := insert(intervals, newInterval)
		fmt.Printf("%+v\n", ret)
	}
	{
		intervals := [][]int{{1, 5}}
		newInterval := []int{0, 3}
		ret := insert(intervals, newInterval)
		fmt.Printf("%+v\n", ret)
	}
	{
		intervals := [][]int{{1, 5}}
		newInterval := []int{0, 0}
		ret := insert(intervals, newInterval)
		fmt.Printf("%+v\n", ret)
	}
	{
		intervals := [][]int{{1, 3}, {6, 9}}
		newInterval := []int{2, 5}
		ret := insert(intervals, newInterval)
		fmt.Printf("%+v\n", ret)
	}
	{
		intervals := [][]int{{1, 5}}
		newInterval := []int{0, 6}
		ret := insert(intervals, newInterval)
		fmt.Printf("%+v\n", ret)
	}
}
