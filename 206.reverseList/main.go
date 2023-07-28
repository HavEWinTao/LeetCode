package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	ret := head
	idx := head
	for idx != nil && idx.Next != nil {
		next := idx.Next
		idx.Next = next.Next
		next.Next = ret
		ret = next
	}
	return ret
}

func main() {
	head := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val: 5,
					},
				},
			},
		},
	}
	ret := reverseList(head)
	fmt.Printf("%+v\n", ret)
}
