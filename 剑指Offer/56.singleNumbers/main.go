package main

import "fmt"

func singleNumbers(nums []int) []int {
	ret := 0
	for _, v := range nums {
		ret ^= v
	}
	div := 1
	for (div & ret) == 0 {
		div <<= 1
	}
	a := 0
	b := 0
	for _, v := range nums {
		if div&v > 0 {
			a ^= v
		} else {
			b ^= v
		}
	}
	return []int{a, b}
}

func main() {
	nums := []int{4, 1, 4, 6}
	ret := singleNumbers(nums)
	fmt.Printf("%+v\n", ret)
}
