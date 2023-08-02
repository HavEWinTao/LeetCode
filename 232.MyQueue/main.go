package main

import "fmt"

type MyQueue struct {
	stack1 []int
	stack2 []int
}

func Constructor() MyQueue {
	return MyQueue{
		stack1: make([]int, 0),
		stack2: make([]int, 0),
	}
}

func (this *MyQueue) Push(x int) {
	this.stack1 = append(this.stack1, x)
}

func (this *MyQueue) Pop() int {
	peek := this.Peek()
	this.stack2 = this.stack2[:len(this.stack2)-1]
	return peek
}

func (this *MyQueue) Peek() int {
	var ret int
	if len(this.stack2) > 0 {
		ret = this.stack2[len(this.stack2)-1]
	} else {
		for len(this.stack1) > 0 {
			this.stack2 = append(this.stack2, this.stack1[len(this.stack1)-1])
			ret = this.stack1[len(this.stack1)-1]
			this.stack1 = this.stack1[:len(this.stack1)-1]
		}
	}
	return ret
}

func (this *MyQueue) Empty() bool {
	return len(this.stack1) == 0 && len(this.stack2) == 0
}

func main() {
	obj := Constructor()
	fmt.Printf("%+v\n", obj.Empty())
	obj.Push(1)
	obj.Push(2)
	obj.Push(3)
	fmt.Printf("%+v\n", obj.Peek())
	fmt.Printf("%+v\n", obj.Pop())
	obj.Push(4)
	fmt.Printf("%+v\n", obj.Peek())
	fmt.Printf("%+v\n", obj.Pop())
	fmt.Printf("%+v\n", obj.Pop())
	fmt.Printf("%+v\n", obj.Pop())
	fmt.Printf("%+v\n", obj.Empty())
}
