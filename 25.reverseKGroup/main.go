package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	if k == 1 {
		return head
	}
	var ret *ListNode
	var start *ListNode
	var last *ListNode
	inc := 0
	for head != nil {
		inc++
		if inc == 1 {
			start = head
			head = head.Next
		} else if inc == k {
			s, t := reverse(start, head.Next) //start tail 区间
			if ret == nil {
				ret = s
			}
			if last != nil {
				last.Next = s
			}
			last = t
			head = last.Next
			inc = 0
		} else {
			head = head.Next
		}
	}
	return ret
}

func reverse(head, tail *ListNode) (*ListNode, *ListNode) {
	ret := head
	temp := head
	for temp != tail && temp.Next != tail {
		next := temp.Next
		temp.Next = next.Next
		next.Next = ret
		ret = next
	}
	return ret, head
}

func main() {
	head := &ListNode{Val: 1}
	l1 := &ListNode{Val: 2}
	l2 := &ListNode{Val: 3}
	l3 := &ListNode{Val: 4}
	l4 := &ListNode{Val: 5}
	head.Next = l1
	l1.Next = l2
	l2.Next = l3
	l3.Next = l4
	ret := reverseKGroup(head, 2)
	fmt.Printf("%+v\n", ret)
}
