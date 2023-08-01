package main

import "sort"

const mod = 1000000007

func sumOfPower(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	var ret int64
	var s int64
	for j := 0; j < n; j++ {
		ret = (ret + int64(nums[j]*nums[j])%mod*(int64(nums[j])+s)) % mod // 中间模一次防止溢出
		s = (s*2 + int64(nums[j])) % mod
	}
	return int(ret)
}
