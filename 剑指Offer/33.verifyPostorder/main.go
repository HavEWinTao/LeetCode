package main

import "fmt"

func verifyPostorder(postorder []int) bool {
	n := len(postorder)
	if n == 0 || n == 1 {
		return true
	}
	pivot := postorder[n-1]
	idx := -1
	for i := 0; i < n-1; i++ {
		if postorder[i] > pivot {
			idx = i
			break
		}
	}
	if idx == -1 {
		return verifyPostorder(postorder[:n-1])
	}
	for i := idx; i < n-1; i++ {
		if postorder[i] < pivot {
			return false
		}
	}
	if idx == 0 {
		return verifyPostorder(postorder[:n-1])
	}
	return verifyPostorder(postorder[:idx]) && verifyPostorder(postorder[idx:n-1])
}

func main() {
	{
		nums := []int{1, 3, 2, 6, 5}
		ret := verifyPostorder(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{1, 6, 3, 2, 5}
		ret := verifyPostorder(nums)
		fmt.Printf("%+v\n", ret)
	}
	{
		nums := []int{1, 2, 5, 10, 6, 9, 4, 3}
		ret := verifyPostorder(nums)
		fmt.Printf("%+v\n", ret)
	}
}
