package main

import "fmt"

type Node struct {
	Val   int
	Prev  *Node
	Next  *Node
	Child *Node
}

func flatten(root *Node) *Node {
	return dfs(root)
}

func dfs(root *Node) *Node {
	ret := root
	for root != nil {
		var lastChild *Node
		if root.Child != nil {
			child := dfs(root.Child)
			for child != nil {
				lastChild = child
				child = child.Next
			}
		}
		if lastChild != nil {
			next := root.Next
			if next != nil {
				next.Prev = lastChild
			}
			lastChild.Next = next
			root.Next = root.Child
			root.Child.Prev = root
			root.Child = nil
			root = next
		} else {
			root = root.Next
		}
	}
	return ret
}

func main() {
	node1 := &Node{Val: 1}
	node3 := &Node{Val: 3}
	node2 := &Node{Val: 2}
	node1.Child = node2
	node2.Child = node3
	ret := flatten(node1)
	fmt.Printf("%+v\n", ret)
}
