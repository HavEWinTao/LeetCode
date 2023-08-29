package main

import (
	"fmt"
	"sort"
)

func numFactoredBinaryTrees(arr []int) int {
	mod := 1000000007
	mp := make(map[int]struct{})
	sort.Ints(arr)
	idx := make(map[int]int)
	for i, v := range arr {
		idx[v] = i
		mp[v] = struct{}{}
	}
	var ans int
	var cal func(root int) int
	cache := make([]int, len(arr))
	cal = func(root int) int {
		ret := 1
		for k := range mp {
			if root%k == 0 {
				u := root / k
				if _, ok := mp[u]; ok {
					ret = (ret + cache[idx[k]]*cache[idx[u]]) % mod
				}
			}
		}
		return ret
	}
	for i := 0; i < len(arr); i++ {
		temp := cal(arr[i])
		cache[i] = temp
		ans = (ans + temp) % mod
	}
	return ans
}

func main() {
	{
		arr := []int{2, 4, 5, 10}
		ret := numFactoredBinaryTrees(arr)
		fmt.Printf("%+v\n", ret)
	}
	{
		arr := []int{2, 4, 5, 10, 20}
		ret := numFactoredBinaryTrees(arr)
		fmt.Printf("%+v\n", ret)
	}
	{
		arr := []int{45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33, 28, 10, 32, 29, 17, 46, 11, 759, 37, 6, 26, 21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30, 43, 15, 4, 16, 35, 25, 20, 44, 5, 48}
		ret := numFactoredBinaryTrees(arr)
		fmt.Printf("%+v\n", ret)
	}
}
