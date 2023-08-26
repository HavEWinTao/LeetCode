package main

import "fmt"

func summaryRanges(nums []int) []string {
	n := len(nums)
	if n == 0 {
		return nil
	}
	ret := make([]string, 0)
	last := nums[0]
	for i := 1; i <= n; i++ {
		if i == n || nums[i] != nums[i-1]+1 {
			if nums[i-1] == last {
				ret = append(ret, fmt.Sprintf("%d", last))
			} else {
				ret = append(ret, fmt.Sprintf("%d->%d", last, nums[i-1]))
			}
			if i != n {
				last = nums[i]
			}
		}
	}
	return ret
}

func main() {
	{
		nums := []int{0, 1, 2, 4, 5, 7}
		ret := summaryRanges(nums)
		fmt.Printf("%+v\n", ret)
	}
}
