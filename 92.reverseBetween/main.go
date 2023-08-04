package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	if left == right {
		return head
	}
	ret := head
	temp := head
	var last *ListNode
	for i := 0; i < left-1; i++ {
		if last == nil {
			last = temp
		} else {
			last = last.Next
		}
		temp = temp.Next
	}
	pre := temp
	cur := temp
	for i := 0; i < right-left; i++ {
		next := cur.Next
		cur.Next = next.Next
		next.Next = pre
		pre = next
	}
	if last != nil {
		last.Next = pre
		return ret
	} else {
		return pre
	}
}

func main() {
	{
		head := &ListNode{Val: 1}
		l2 := &ListNode{Val: 2}
		l3 := &ListNode{Val: 3}
		l4 := &ListNode{Val: 4}
		l5 := &ListNode{Val: 5}
		l6 := &ListNode{Val: 6}
		head.Next = l2
		l2.Next = l3
		l3.Next = l4
		l4.Next = l5
		l5.Next = l6
		ret := reverseBetween(head, 2, 5)
		fmt.Printf("%+v\n", ret)
	}
	{
		head := &ListNode{Val: 3}
		l2 := &ListNode{Val: 5}
		head.Next = l2
		ret := reverseBetween(head, 1, 2)
		fmt.Printf("%+v\n", ret)
	}
}
