package main

import (
	"fmt"
)

func minimumJumps(forbidden []int, a int, b int, x int) int {
	if x == 0 {
		return 0
	}
	bound := 2000 + a + b
	visit := make([]bool, bound+1)
	for _, v := range forbidden {
		visit[v] = true
	}
	var dfs func(cur, steps int, isForward bool) int
	dfs = func(cur, steps int, isForward bool) int {
		if cur < 0 || cur > bound || visit[cur] {
			return -1
		}
		steps++
		if cur == x {
			return steps
		}
		if isForward {
			visit[cur] = true
		}
		forwardSteps := -1
		backwardSteps := -1
		nextForwardPos := cur + a
		nextBackwardPos := cur - b
		if nextBackwardPos >= x {
			if isForward {
				backwardSteps = dfs(nextBackwardPos, steps, false)
			}
			if backwardSteps == -1 {
				forwardSteps = dfs(nextForwardPos, steps, true)
			}
		} else {
			forwardSteps = dfs(nextForwardPos, steps, true)
			if forwardSteps == -1 && isForward {
				backwardSteps = dfs(nextBackwardPos, steps, false)
			}
		}
		if forwardSteps == -1 {
			return backwardSteps
		}
		return forwardSteps
	}
	return dfs(a, 0, true)
}

func main() {
	{
		forbidden := []int{14, 4, 18, 1, 15}
		a := 3
		b := 15
		x := 9
		ret := minimumJumps(forbidden, a, b, x)
		fmt.Printf("%+v\n", ret)
	}
	{
		forbidden := []int{8, 3, 16, 6, 12, 20}
		a := 15
		b := 13
		x := 11
		ret := minimumJumps(forbidden, a, b, x)
		fmt.Printf("%+v\n", ret)
	}
	{
		forbidden := []int{1, 6, 2, 14, 5, 17, 4}
		a := 16
		b := 9
		x := 7
		ret := minimumJumps(forbidden, a, b, x)
		fmt.Printf("%+v\n", ret)
	}
	{
		forbidden := []int{128, 178, 147, 165, 63, 11, 150, 20, 158, 144, 136}
		a := 61
		b := 170
		x := 135
		ret := minimumJumps(forbidden, a, b, x)
		fmt.Printf("%+v\n", ret)
	}
}
