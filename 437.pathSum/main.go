package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pathSum(root *TreeNode, targetSum int) int {
	if root == nil {
		return 0
	}
	ret := 0
	var dfs func(node *TreeNode, sum int)
	dfs = func(node *TreeNode, sum int) {
		if sum == targetSum {
			ret++
		}
		if node == nil {
			return
		}
		if node.Left != nil {
			dfs(node.Left, sum+node.Left.Val)
		}
		if node.Right != nil {
			dfs(node.Right, sum+node.Right.Val)
		}
	}
	queue := make([]*TreeNode, 0)
	queue = append(queue, root)
	idx := 0
	for idx < len(queue) {
		node := queue[idx]
		dfs(node, node.Val)
		if node.Left != nil {
			queue = append(queue, node.Left)
		}
		if node.Right != nil {
			queue = append(queue, node.Right)
		}
		idx++
	}
	return ret
}

func main() {
	root := &TreeNode{
		Val: 1,
		Right: &TreeNode{
			Val: 2,
			Right: &TreeNode{
				Val: 3,
				Right: &TreeNode{
					Val:   4,
					Right: &TreeNode{Val: 5},
				},
			},
		},
	}
	ret := pathSum(root, 3)
	fmt.Printf("%+v\n", ret)
}
