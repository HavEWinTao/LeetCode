package main

import (
	"fmt"
	"math"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxPathSum(root *TreeNode) int {
	ans := math.MinInt
	var dfs func(root *TreeNode) int
	dfs = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		left := dfs(root.Left)
		right := dfs(root.Right)
		// 更新答案
		temp := root.Val + maxInt(0, left) + maxInt(0, right)
		ans = maxInt(ans, temp)
		return root.Val + maxInt(0, maxInt(left, right))
	}
	dfs(root)
	return ans
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	{
		root := &TreeNode{
			Val:  -10,
			Left: &TreeNode{Val: 9},
			Right: &TreeNode{
				Val:   20,
				Left:  &TreeNode{Val: 15},
				Right: &TreeNode{Val: 7},
			},
		}
		ret := maxPathSum(root)
		fmt.Printf("%+v\n", ret)
	}
	{
		root := &TreeNode{
			Val:  2,
			Left: &TreeNode{Val: -1},
		}
		ret := maxPathSum(root)
		fmt.Printf("%+v\n", ret)
	}
	{
		root := &TreeNode{
			Val:  9,
			Left: &TreeNode{Val: 6},
			Right: &TreeNode{
				Val:  -3,
				Left: &TreeNode{Val: -6},
				Right: &TreeNode{
					Val: 2,
					Left: &TreeNode{
						Val: 2,
						Left: &TreeNode{
							Val:  -6,
							Left: &TreeNode{Val: -6},
						},
						Right: &TreeNode{Val: -6},
					},
				},
			},
		}
		ret := maxPathSum(root)
		fmt.Printf("%+v\n", ret)
	}
}
