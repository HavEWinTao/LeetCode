package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	ret := &ListNode{Next: head}
	temp := head
	pre := ret
	for temp != nil && temp.Next != nil {
		next := temp.Next
		pre.Next = next
		temp.Next = next.Next
		next.Next = temp
		pre = temp
		temp = temp.Next
	}
	return ret.Next
}

func main() {
	{
		list := &ListNode{Val: 1}
		node2 := &ListNode{Val: 2}
		node3 := &ListNode{Val: 3}
		node4 := &ListNode{Val: 4}

		list.Next = node2
		node2.Next = node3
		node3.Next = node4
		ret := swapPairs(list)
		fmt.Printf("%+v\n", ret)
	}
	{
		list := &ListNode{Val: 1}
		ret := swapPairs(list)
		fmt.Printf("%+v\n", ret)
	}
	{
		var list *ListNode
		ret := swapPairs(list)
		fmt.Printf("%+v\n", ret)
	}
}
