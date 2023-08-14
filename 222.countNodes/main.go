package main

import "sort"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	depth := 0
	for node := root; node.Left != nil; node = node.Left {
		depth++
	}
	return sort.Search(1<<(depth+1), func(k int) bool {
		if k <= 1<<depth { // 肯定在最后一层，二叉树性质
			return false
		}
		bits := 1 << (depth - 1) // 最底下的层分两侧，如果是和k做&1，就是右半侧
		node := root
		for node != nil && bits > 0 {
			if bits&k == 0 {
				node = node.Left
			} else {
				node = node.Right
			}
			bits >>= 1
		}
		return node == nil
	}) - 1
}
