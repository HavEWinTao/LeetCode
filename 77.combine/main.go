package main

func combine(n int, k int) [][]int {
	ret := make([][]int, 0)
	var dfs func(nums []int, bound, depth int)
	dfs = func(nums []int, bound, depth int) {
		if depth == k {
			temp := make([]int, k)
			copy(temp, nums)
			ret = append(ret, temp)
			return
		}
		for i := bound; i <= n; i++ {
			nums[depth] = i
			dfs(nums, i+1, depth+1)
		}
	}
	dfs(make([]int, k), 1, 0)
	return ret
}
