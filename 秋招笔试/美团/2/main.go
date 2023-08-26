package main

import "fmt"

// 出去玩所有钱都是小红支付，他现在群收款，求应从每个人那里收多少钱
// n个账单，m个人（除小红外）
// 每个账单涉及的人数k，和账单花费c，每个账单k-1个涉及的人
func main() {
	var n, m int
	fmt.Scan(&n, &m)
	cost := make([]int, m+1)
	var k, c int
	var people int
	for i := 0; i < n; i++ {
		fmt.Scan(&k, &c)
		asc := c / k
		if c%k != 0 {
			asc++
		}
		for j := 0; j < k-1; j++ {
			fmt.Scan(&people)
			cost[people] += asc
		}
	}
	for i := 1; i <= m; i++ {
		fmt.Printf("%d", cost[i])
		if i == m {
			fmt.Printf("\n")
		} else {
			fmt.Printf(" ")
		}
	}
}
