package main

import (
	"fmt"
)

const mod = 1000000007

func cuttingRope(n int) int {
	if n <= 3 {
		return n - 1
	}
	a := n / 3
	b := n % 3
	if b == 1 {
		return (myPow(3, a-1) * 4) % mod
	}
	if b == 2 {
		return (myPow(3, a-1) * 6) % mod
	}
	return myPow(3, a)
}

func myPow(x int, n int) int {
	return quickMul(x, n)
}

func quickMul(x int, n int) int {
	if n == 0 {
		return 1
	}
	y := quickMul(x, n/2) % mod
	if n%2 == 0 {
		return (y * y) % mod
	}
	return (y * y * x) % mod
}

func main() {
	{
		ret := cuttingRope(2)
		fmt.Printf("%+v\n", ret)
	}
	{
		ret := cuttingRope(10)
		fmt.Printf("%+v\n", ret)
	}
}
