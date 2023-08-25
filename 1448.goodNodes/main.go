package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func goodNodes(root *TreeNode) int {
	ans := 0
	var dfs func(root *TreeNode, maxVal int)
	dfs = func(root *TreeNode, maxVal int) {
		if root == nil {
			return
		}
		if root.Val >= maxVal {
			maxVal = root.Val
			ans++
		}
		dfs(root.Left, maxVal)
		dfs(root.Right, maxVal)
	}
	dfs(root, root.Val)
	return ans
}
