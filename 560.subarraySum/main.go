package main

import "fmt"

func subarraySum(nums []int, k int) int {
	n := len(nums)
	ans := 0
	sum := 0
	mp := make(map[int]int)
	mp[0] = 1
	for i := 0; i < n; i++ {
		sum += nums[i]
		if _, ok := mp[sum-k]; ok {
			ans += mp[sum-k]
		}
		mp[sum] += 1
	}
	return ans
}

func main() {
	{
		nums := []int{1, 1, 1}
		ret := subarraySum(nums, 2)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{1, 2, 3}
		ret := subarraySum(nums, 3)
		fmt.Printf("%+v\n", ret)
	}
}
