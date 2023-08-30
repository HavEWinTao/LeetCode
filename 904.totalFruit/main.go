package main

import "fmt"

func totalFruit(fruits []int) int {
	n := len(fruits)
	mp := make(map[int]int)
	var i, j int
	ans := 0
	for j < n {
		if v, ok := mp[fruits[j]]; ok {
			mp[fruits[j]] = v + 1
			j++
			ans = maxInt(ans, j-i)
		} else if len(mp) < 2 {
			mp[fruits[j]] = 1
			j++
			ans = maxInt(ans, j-i)
		} else {
			ans = maxInt(ans, j-i)
			for len(mp) == 2 {
				cnt, _ := mp[fruits[i]]
				if cnt == 1 {
					delete(mp, fruits[i])
				} else {
					mp[fruits[i]] = cnt - 1
				}
				i++
			}
		}
	}
	return ans
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	{
		fruits := []int{0, 1, 2, 2}
		ret := totalFruit(fruits)
		fmt.Printf("%+v\n", ret)
	}
	{
		fruits := []int{1, 2, 1}
		ret := totalFruit(fruits)
		fmt.Printf("%+v\n", ret)
	}
	{
		fruits := []int{1, 2, 3, 2, 2}
		ret := totalFruit(fruits)
		fmt.Printf("%+v\n", ret)
	}
	{
		fruits := []int{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}
		ret := totalFruit(fruits)
		fmt.Printf("%+v\n", ret)
	}
}
