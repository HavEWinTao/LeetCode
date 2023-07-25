package main

import "sort"

func maxOperations(nums []int, k int) int {
	sort.Ints(nums)
	j := len(nums) - 1
	ret := 0
	for i := 0; i < j; i++ {
		for i < j && nums[j]+nums[i] > k {
			j--
		}
		if i == j {
			break
		}
		if nums[i]+nums[j] == k {
			ret++
			j--
		} else {
			continue
		}
	}
	return ret
}
