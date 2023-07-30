package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

/*
x = m +n
2x = 2(m+n) = m+n +m(走到交叉点) +n
*/
func detectCycle(head *ListNode) *ListNode {
	slow := head
	fast := head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			slow = head
			for slow != fast {
				slow = slow.Next
				fast = fast.Next
			}
			return slow
		}
	}
	return nil
}

func main() {
	node1 := &ListNode{Val: 3}
	node2 := &ListNode{Val: 2}
	node3 := &ListNode{Val: 0}
	node4 := &ListNode{Val: -4}
	node1.Next = node2
	node2.Next = node3
	node3.Next = node4
	node4.Next = node2
	ret := detectCycle(node1)
	fmt.Printf("%+v\n", ret)
}
