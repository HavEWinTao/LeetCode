package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSubStructure(A *TreeNode, B *TreeNode) bool {
	if A == nil || B == nil {
		return false
	}
	flag1 := dfs(A, B)
	flag2 := isSubStructure(A.Left, B)
	flag3 := isSubStructure(A.Right, B)
	return flag1 || flag2 || flag3
}

func dfs(node, B *TreeNode) bool {
	if node == nil && B != nil {
		return false
	}
	if B == nil {
		return true
	}
	if node.Val == B.Val {
		return dfs(node.Left, B.Left) && dfs(node.Right, B.Right)
	}
	return false
}

func main() {
	{
		A := &TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val:   4,
				Left:  &TreeNode{Val: 1},
				Right: &TreeNode{Val: 2},
			},
			Right: &TreeNode{Val: 5},
		}
		B := &TreeNode{
			Val:  4,
			Left: &TreeNode{Val: 1},
		}
		ret := isSubStructure(A, B)
		fmt.Printf("%+v\n", ret)
	}
	{
		A := &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val:  2,
				Left: &TreeNode{Val: 4},
			},
			Right: &TreeNode{Val: 3},
		}
		B := &TreeNode{Val: 3}
		ret := isSubStructure(A, B)
		fmt.Printf("%+v\n", ret)
	}
}
