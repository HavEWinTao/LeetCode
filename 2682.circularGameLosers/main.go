package main

func circularGameLosers(n int, k int) []int {
	visit := make([]bool, n)
	cur := 1
	idx := 0
	for {
		if visit[idx] {
			break
		}
		visit[idx] = true
		idx = (idx + cur*k) % n
		cur++
	}
	ret := make([]int, 0)
	for i := 0; i < n; i++ {
		if !visit[i] {
			ret = append(ret, i+1)
		}
	}
	return ret
}
