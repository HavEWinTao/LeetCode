package template

func unbounded_knapsack(capacity int, w, v []int) int {
	n := len(w)
	return dfs(n-1, capacity, w, v)
}

// cache
func dfs(i, c int, w, v []int) int {
	if i < 0 {
		return 0
	}
	if c < w[i] {
		return dfs(i-1, c, w, v)
	}
	return maxInt(dfs(i-1, c, w, v), dfs(i, c-w[i]+v[i], w, v))
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
