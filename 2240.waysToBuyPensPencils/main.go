package main

import "fmt"

func waysToBuyPensPencils(total int, cost1 int, cost2 int) int64 {
	var ans int64
	for i := 0; i*cost1 <= total; i++ {
		remain := total - i*cost1
		ans += int64(remain/cost2) + 1
	}
	return ans
}

func main() {
	{
		total := 20
		cost1 := 10
		cost2 := 5
		ret := waysToBuyPensPencils(total, cost1, cost2)
		fmt.Printf("%+v\n", ret)
	}
}
