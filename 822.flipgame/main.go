package main

import "math"

func flipgame(fronts []int, backs []int) int {
	n := len(fronts)
	ret := math.MaxInt
	fib := make(map[int]struct{}) //不允许选的数字
	for i := 0; i < n; i++ {
		if fronts[i] == backs[i] {
			fib[fronts[i]] = struct{}{}
		}
	}
	for i := 0; i < n; i++ {
		if _, ok := fib[fronts[i]]; !ok {
			ret = minInt(ret, fronts[i])
		}
		if _, ok := fib[backs[i]]; !ok {
			ret = minInt(ret, backs[i])
		}
	}
	if ret == math.MaxInt {
		return 0
	}
	return ret
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}
