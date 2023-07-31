package template

func zero_one_knapsack(capacity int, w, v []int) int {
	n := len(w)
	return dfs(n-1, capacity, w, v)
}

func dfs(i, c int, w, v []int) int {
	if i < 0 {
		return 0
	}
	if c < w[i] {
		return dfs(i-1, c, w, v)
	}
	return maxInt(dfs(i-1, c, w, v), dfs(i-1, c-w[i]+v[i], w, v))
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
