package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	n := len(nums)
	sort.Ints(nums)
	ret := make([][]int, 0)
	for first := 0; first < n-2; first++ {
		if first > 0 && nums[first] == nums[first-1] {
			continue
		}
		target := -nums[first]
		third := n - 1
		for second := first + 1; second < n-1; second++ {
			if second > first+1 && nums[second] == nums[second-1] {
				continue
			}
			for third > second && nums[second]+nums[third] > target {
				third--
			}
			if third <= second {
				break
			}
			if nums[second]+nums[third] == target {
				ret = append(ret, []int{nums[first], nums[second], nums[third]})
			}
		}
	}
	return ret
}

func main() {
	nums := []int{-1, 0, 1, 2, -1, -4}
	fmt.Printf("%+v\n", threeSum(nums))
}
