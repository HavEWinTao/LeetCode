package main

func maxAbsoluteSum(nums []int) int {
	ret := 0
	sum := 0
	temp := 0
	for i := 0; i < len(nums); i++ {
		if sum < 0 {
			sum = 0
		}
		sum += nums[i]
		temp = maxInt(temp, sum)
	}
	ret = maxInt(ret, temp)
	sum = 0
	temp = 0
	for i := 0; i < len(nums); i++ {
		if sum > 0 {
			sum = 0
		}
		sum += nums[i]
		temp = minInt(temp, sum)
	}
	ret = maxInt(ret, -temp)
	return ret
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
