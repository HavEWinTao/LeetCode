package main

import (
	"fmt"
	"sort"
)

// LIS O(nlogn)解法
func LIS(arr []int) []int {
	if len(arr) == 0 {
		return []int{}
	}
	tail := make([]int, len(arr))
	tail[0] = arr[0]
	ans := 1
	dp := make([]int, len(arr))
	dp[0] = 1
	for i := 1; i < len(arr); i++ {
		if arr[i] > tail[ans-1] {
			tail[ans] = arr[i]
			ans++
			dp[i] = ans
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
		dp[i] = idx + 1
	}
	ret := make([]int, ans)
	for i := len(arr) - 1; i >= 0; i-- {
		if dp[i] == ans {
			ans--
			ret[ans] = arr[i]
		}
	}
	return ret
}

func main() {
	{
		nums := []int{6, 3, 1, 5, 2, 3, 7}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{3, 5, 7, 1, 2, 4, 6, 3, 8, 9, 5, 6}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
	//单调栈：错误解法，处理不来这种情况
	{
		nums := []int{1, 2, 3, 4, 3, 5}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{4, 10, 4, 3, 8, 9}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{1, 2, 8, 6, 4}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{2, 1, 5, 3, 6, 4, 8, 9, 7}
		ret := LIS(nums)
		fmt.Printf("%+v\n", ret)
	}
}
