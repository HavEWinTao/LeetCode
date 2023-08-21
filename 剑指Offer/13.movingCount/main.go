package main

import "fmt"

func movingCount(m int, n int, k int) int {
	vis := make([][]bool, m)
	for i := 0; i < m; i++ {
		vis[i] = make([]bool, n)
	}
	ret := 0
	var dfs func(x, y int)
	vec := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	dfs = func(x, y int) {
		if cal(x)+cal(y) > k {
			return
		}
		if vis[x][y] {
			return
		}
		ret++
		vis[x][y] = true
		for i := 0; i < 4; i++ {
			tx := x + vec[i][0]
			ty := y + vec[i][1]
			if tx < 0 || tx == m || ty < 0 || ty == n {
				continue
			}
			dfs(tx, ty)
		}
	}
	dfs(0, 0)
	return ret
}

func cal(num int) int {
	ret := 0
	for num > 0 {
		ret += num % 10
		num /= 10
	}
	return ret
}

func main() {
	{
		ret := movingCount(2, 3, 1)
		fmt.Printf("%+v\n", ret)
	}
	{
		ret := movingCount(3, 1, 0)
		fmt.Printf("%+v\n", ret)
	}
	{
		ret := movingCount(4, 6, 15)
		fmt.Printf("%+v\n", ret)
	}
}
