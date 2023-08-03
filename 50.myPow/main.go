package main

import "fmt"

var cache map[int]float64

func myPow(x float64, n int) float64 {
	if n < 0 {
		x = 1 / x
		n = -n
	}
	cache = make(map[int]float64)
	return quickPow(x, n)
}

func quickPow(x float64, n int) (ret float64) {
	if n == 0 {
		return 1
	}
	if n == 1 {
		return x
	}
	if _, ok := cache[n]; ok {
		return cache[n]
	}
	defer func() { cache[n] = ret }()
	if n&1 == 1 {
		return quickPow(x, n/2) * quickPow(x, n/2) * x
	}
	return quickPow(x, n/2) * quickPow(x, n/2)
}

// 答案，答案少了一点搜索深度
func myPowAns(x float64, n int) float64 {
	if n >= 0 {
		return quickMul(x, n)
	}
	return 1.0 / quickMul(x, -n)
}

func quickMul(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	y := quickMul(x, n/2)
	if n%2 == 0 {
		return y * y
	}
	return y * y * x
}

func main() {
	fmt.Printf("%+v\n", myPow(2, 10))
	fmt.Printf("%+v\n", myPow(2, -2))
	fmt.Printf("%+v\n", myPow(0.00001, 2147483647))
}
