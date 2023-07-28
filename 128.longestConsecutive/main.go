package main

import (
	"fmt"
	"sort"
)

func longestConsecutive(nums []int) int {
	mp := make(map[int]bool)
	for _, v := range nums {
		mp[v] = true
	}
	ret := 0
	for _, v := range nums {
		if !mp[v-1] {
			bound := v
			temp := 1
			for mp[bound+1] {
				bound++
				temp++
			}
			ret = maxInt(ret, temp)
		}
	}
	return ret
}

// nlogn
func longestConsecutive1(nums []int) int {
	sort.Ints(nums)
	ret := 0
	idx := 0
	for idx < len(nums) {
		temp := 1
		for idx+1 < len(nums) {
			if nums[idx]+1 == nums[idx+1] {
				temp++
			} else if nums[idx] != nums[idx+1] {
				break
			}
			idx++
		}
		idx++
		ret = maxInt(ret, temp)
	}
	return ret
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	nums := []int{100, 4, 200, 1, 3, 2}
	fmt.Printf("%+v\n", longestConsecutive1(nums))
	fmt.Printf("%+v\n", longestConsecutive(nums))
}
