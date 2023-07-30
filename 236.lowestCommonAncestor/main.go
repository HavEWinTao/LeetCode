package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	parentMap := make(map[int]*TreeNode)
	parentMap[root.Val] = nil
	dfs(parentMap, root)
	mp := make(map[int]*TreeNode)
	for {
		if p == nil {
			break
		}
		if v, ok := parentMap[p.Val]; ok {
			mp[p.Val] = p
			p = v
		} else {
			break
		}
	}
	for {
		if v, ok := mp[q.Val]; ok {
			return v
		}
		if v, ok := parentMap[q.Val]; ok {
			q = v
		} else {
			break
		}
	}
	return nil
}

func dfs(parentMap map[int]*TreeNode, root *TreeNode) {
	if root.Left != nil {
		parentMap[root.Left.Val] = root
		dfs(parentMap, root.Left)
	}
	if root.Right != nil {
		parentMap[root.Right.Val] = root
		dfs(parentMap, root.Right)
	}
}

func main() {
	root := &TreeNode{Val: 3}

	l := &TreeNode{Val: 5}
	l_l := &TreeNode{Val: 6}
	l_r := &TreeNode{Val: 2}
	l_r_l := &TreeNode{Val: 7}
	l_r_r := &TreeNode{Val: 4}

	r := &TreeNode{Val: 1}
	r_l := &TreeNode{Val: 0}
	r_r := &TreeNode{Val: 8}

	root.Left = l
	root.Right = r
	l.Left = l_l
	l.Right = l_r
	l_r.Left = l_r_l
	l_r.Right = l_r_r
	r.Left = r_l
	r.Right = r_r

	ret := lowestCommonAncestor(root, l_r, r_l)
	fmt.Printf("%+v\n", ret)
}
