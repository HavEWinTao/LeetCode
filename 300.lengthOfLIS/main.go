package main

import "sort"

func lengthOfLIS(arr []int) int {
	if len(arr) == 0 {
		return 0
	}
	tail := make([]int, len(arr))
	tail[0] = arr[0]
	ans := 1
	for i := 1; i < len(arr); i++ {
		if arr[i] > tail[ans-1] {
			tail[ans] = arr[i]
			ans++
			continue
		}
		//在tail中找到第一个比nums[i]小的，返回下标
		idx := sort.Search(ans, func(j int) bool {
			if tail[j] < arr[i] {
				return false
			}
			return true
		})
		tail[idx] = arr[i]
	}
	return ans
}
