package main

import (
	"fmt"
)

func main() {
	var n int
	fmt.Scan(&n)
	a := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&a[i])
	}
	stack := NewStack(n + 10)
	win := 0
	for i := 0; i < n; i++ {
		for !stack.isEmpty() && stack.Peek() >= a[i] {
			stack.Pop()
		}
		if !stack.isEmpty() {
			win++
		}
		stack.Push(a[i])
	}
	if win == n {
		fmt.Println("1/1")
		return
	}
	if win == 0 {
		fmt.Println("0/1")
		return
	}
	win, n = fn(win, n)
	fmt.Println(fmt.Sprintf("%d/%d", win, n))
}

type Stack struct {
	arr []int
	top int
}

func NewStack(size int) *Stack {
	return &Stack{
		arr: make([]int, size),
		top: 0,
	}
}

func (s *Stack) isEmpty() bool {
	return s.top == 0
}

func (s *Stack) Push(num int) {
	s.arr[s.top] = num
	s.top++
}

func (s *Stack) Peek() int {
	return s.arr[s.top-1]
}

func (s *Stack) Pop() int {
	ret := s.arr[s.top-1]
	s.top--
	return ret
}

func fn(a, b int) (int, int) {
	for i := 2; i <= a; i++ {
		if a%i == 0 && b%i == 0 {
			return fn(a/i, b/i)
		}
	}
	return a, b
}
