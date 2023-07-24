package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var ret int

func distributeCoins(root *TreeNode) int {
	ret = 0
	DFS(root)
	return ret
}

func DFS(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := DFS(root.Left)
	right := DFS(root.Right)
	sum := left + right
	ret += absInt(left) + absInt(right)
	return root.Val + sum - 1
}

func absInt(num int) int {
	if num > 0 {
		return num
	}
	return -num
}

func main() {
	root1 := &TreeNode{
		Val:   3,
		Left:  &TreeNode{Val: 0},
		Right: &TreeNode{Val: 0},
	}
	fmt.Println(distributeCoins(root1))

	root2 := &TreeNode{
		Val:   0,
		Left:  &TreeNode{Val: 3},
		Right: &TreeNode{Val: 0},
	}
	fmt.Println(distributeCoins(root2))
}
