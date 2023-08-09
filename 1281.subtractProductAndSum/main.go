package main

func subtractProductAndSum(n int) int {
	mul := 1
	sum := 0
	for n != 0 {
		c := n % 10
		n /= 10
		mul *= c
		sum += c
	}
	return mul - sum
}
