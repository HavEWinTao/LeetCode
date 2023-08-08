package main

import (
	"fmt"
	"math"
)

func integerBreak(n int) int {
	ret := 0
	for m := 2; m <= n; m++ {
		temp := math.Pow(float64(n/m), float64(m-n%m)) * math.Pow(float64(n/m+1), float64(n%m))
		ret = maxInt(ret, int(temp))
	}
	return ret
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	{
		ret := integerBreak(2)
		fmt.Printf("%+v\n", ret)
	}
	{
		ret := integerBreak(10)
		fmt.Printf("%+v\n", ret)
	}
}
