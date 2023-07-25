package main

import (
	"container/heap"
	"fmt"
)

type FloatHeap []float64

func (l FloatHeap) Len() int {
	return len(l)
}

func (l FloatHeap) Less(i, j int) bool {
	return l[i] > l[j]
}
func (l FloatHeap) Swap(i, j int) {
	l[i], l[j] = l[j], l[i]
}

func (l *FloatHeap) Pop() interface{} {
	old := *l
	n := len(old)
	x := old[n-1]
	*l = old[0 : n-1]
	return x
}

func (l *FloatHeap) Push(x interface{}) {
	*l = append(*l, x.(float64))
}

func halveArray(nums []int) int {
	var sum float64
	h := make(FloatHeap, 0)
	for _, num := range nums {
		sum += float64(num)
		h = append(h, float64(num))
	}
	ret := 0
	var sub float64
	heap.Init(&h)
	for sub*2 < sum {
		pop := heap.Pop(&h)
		sub += pop.(float64) / 2
		heap.Push(&h, pop.(float64)/2)
		ret++
	}
	return ret
}

func main() {
	nums := []int{6, 58, 10, 84, 35, 8, 22, 64, 1, 78, 86, 71, 77}
	fmt.Printf("%+v\n", halveArray(nums))
}
