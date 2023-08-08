package main

import "fmt"

func hammingWeight(num uint32) int {
	var idx uint32
	idx = 1
	ret := 0
	for i := 0; i < 32; i++ {
		if ((idx << i) & num) == (idx << i) {
			ret++
		}
	}
	return ret
}

func main() {
	{
		var n uint32
		n = 11
		ret := hammingWeight(n)
		fmt.Printf("%+v\n", ret)
	}
	{
		var n uint32
		n = 128
		ret := hammingWeight(n)
		fmt.Printf("%+v\n", ret)
	}
	{
		var n uint32
		n = 4294967293
		ret := hammingWeight(n)
		fmt.Printf("%+v\n", ret)
	}
}
