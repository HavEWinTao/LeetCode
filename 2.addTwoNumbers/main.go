package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// 快手二面
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var ret *ListNode
	var tail *ListNode
	c := 0
	for l1 != nil || l2 != nil {
		num1 := 0
		if l1 != nil {
			num1 = l1.Val
			l1 = l1.Next
		}
		num2 := 0
		if l2 != nil {
			num2 = l2.Val
			l2 = l2.Next
		}
		temp := num1 + num2 + c
		c = temp / 10
		if ret == nil {
			ret = &ListNode{Val: temp % 10}
			tail = ret
		} else {
			tail.Next = &ListNode{Val: temp % 10}
			tail = tail.Next
		}
	}
	if c != 0 {
		tail.Next = &ListNode{Val: c}
	}
	return ret
}

func main() {
	head1 := &ListNode{
		Val: 2,
		Next: &ListNode{
			Val:  4,
			Next: &ListNode{Val: 3},
		},
	}
	head2 := &ListNode{
		Val: 5,
		Next: &ListNode{
			Val:  6,
			Next: &ListNode{Val: 4},
		},
	}
	ret := addTwoNumbers(head1, head2)
	fmt.Printf("%+v\n", ret)
}
