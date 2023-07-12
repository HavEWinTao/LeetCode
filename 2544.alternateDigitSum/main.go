package main

import "fmt"

func alternateDigitSum(n int) int {
	var (
		ret  int
		flag int
		cnt  int
	)
	flag = 1
	for n != 0 {
		ret = ret + flag*(n%10)
		n /= 10
		flag *= -1
		cnt++
	}
	if cnt%2 == 0 {
		ret = -ret
	}
	return ret
}

func main() {
	fmt.Println(alternateDigitSum(521))
}
