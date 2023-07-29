package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteNode(node *ListNode) {
	*node = *node.Next
}

func main() {
	head := &ListNode{
		Val: 4,
	}
	l1 := &ListNode{
		Val: 5,
	}
	l2 := &ListNode{
		Val: 7,
	}
	l3 := &ListNode{
		Val: 9,
	}
	head.Next = l1
	l1.Next = l2
	l2.Next = l3
	deleteNode(l1)
	fmt.Printf("finished!\n")
}
