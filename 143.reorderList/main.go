package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func reorderList(head *ListNode) {
	if head.Next == nil {
		return
	}
	mid := findMid(head)
	rev := reverse(mid)
	iter1 := head
	iter2 := rev
	for iter1 != nil && iter2 != nil {
		temp := iter2
		iter2 = iter2.Next
		temp.Next = iter1.Next
		iter1.Next = temp
		iter1 = iter1.Next
		if iter1.Next != nil {
			iter1 = iter1.Next
		}
	}
}

func findMid(head *ListNode) *ListNode { //奇数个返回中间的，偶数个返回第二部分的第一个
	slow := head
	fast := head
	var last *ListNode
	for fast != nil && fast.Next != nil {
		last = slow
		slow = slow.Next
		fast = fast.Next.Next
	}
	if last != nil {
		last.Next = nil
	}
	return slow
}

func reverse(head *ListNode) *ListNode {
	ret := head
	temp := head
	for temp != nil && temp.Next != nil {
		next := temp.Next
		temp.Next = next.Next
		next.Next = ret
		ret = next
	}
	return ret
}

func main() {
	{
		head := &ListNode{Val: 1}
		l1 := &ListNode{Val: 2}
		l2 := &ListNode{Val: 3}
		l3 := &ListNode{Val: 4}
		l4 := &ListNode{Val: 5}
		head.Next = l1
		l1.Next = l2
		l2.Next = l3
		l3.Next = l4
		reorderList(head)
		fmt.Printf("%+v\n", head)
	}
	{
		head := &ListNode{Val: 1}
		l1 := &ListNode{Val: 2}
		l2 := &ListNode{Val: 3}
		l3 := &ListNode{Val: 4}
		head.Next = l1
		l1.Next = l2
		l2.Next = l3
		reorderList(head)
		fmt.Printf("%+v\n", head)
	}
	{
		head := &ListNode{Val: 1}
		reorderList(head)
		fmt.Printf("%+v\n", head)
	}
}
