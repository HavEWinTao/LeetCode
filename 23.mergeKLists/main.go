package main

import (
	"container/heap"
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

type ListHeap []*ListNode

func (h ListHeap) Len() int {
	return len(h)
}

func (h ListHeap) Less(i, j int) bool {
	if h[i] == nil {
		return true
	}
	if h[j] == nil {
		return false
	}
	return h[i].Val < h[j].Val
}
func (h ListHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *ListHeap) Push(x any) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(*ListNode))
}

func (h *ListHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func mergeKLists(lists []*ListNode) *ListNode {
	ret := &ListNode{
		Val:  -1,
		Next: nil,
	}
	tail := ret
	var listHeap = new(ListHeap)
	*listHeap = lists
	heap.Init(listHeap)
	for len(*listHeap) > 0 {
		top := heap.Pop(listHeap).(*ListNode)
		if top == nil {
			continue
		}
		tail.Next = &ListNode{Val: top.Val}
		tail = tail.Next
		if top.Next != nil {
			top = top.Next
			heap.Push(listHeap, top)
		}
	}
	return ret.Next
}

func main() {
	{
		l1 := &ListNode{
			Val: 1,
			Next: &ListNode{
				Val:  4,
				Next: &ListNode{Val: 5},
			},
		}
		l2 := &ListNode{
			Val: 1,
			Next: &ListNode{
				Val:  3,
				Next: &ListNode{Val: 4},
			},
		}
		l3 := &ListNode{
			Val:  2,
			Next: &ListNode{Val: 6},
		}
		lists := []*ListNode{l1, l2, l3}
		ret := mergeKLists(lists)
		for ret != nil {
			fmt.Printf("%+v\n", ret.Val)
			ret = ret.Next
		}
	}
	{
		var lists []*ListNode
		ret := mergeKLists(lists)
		for ret != nil {
			fmt.Printf("%+v\n", ret.Val)
			ret = ret.Next
		}
	}
	{
		var l1 *ListNode
		lists := []*ListNode{l1}
		ret := mergeKLists(lists)
		for ret != nil {
			fmt.Printf("%+v\n", ret.Val)
			ret = ret.Next
		}
	}
}
