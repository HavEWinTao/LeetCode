package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
	if root1 == nil {
		return root2
	}
	if root2 == nil {
		return root1
	}
	dfs(root1, root2)
	return root1
}

func dfs(root1, root2 *TreeNode) {
	if root2 == nil {
		return
	}
	root1.Val += root2.Val
	if root1.Left == nil {
		root1.Left = root2.Left
		root2.Left = nil
	} else {
		dfs(root1.Left, root2.Left)
	}
	if root1.Right == nil {
		root1.Right = root2.Right
		root2.Right = nil
	} else {
		dfs(root1.Right, root2.Right)
	}
}
