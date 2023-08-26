package main

import "fmt"

// 浇水成熟度增加x，施肥成熟度增加y，所需成熟度z
// 每天可以浇水，每隔两天才可以施肥
// 求多少天才可以到达成熟度z
func main() {
	var x, y, z int
	fmt.Scanf("%d %d %d\n", &x, &y, &z)
	temp := 3*x + y
	if z%temp == 0 {
		fmt.Println(z / temp * 3)
		return
	}
	if z%temp <= x+y {
		fmt.Println(z/temp*3 + 1)
		return
	}
	if z%temp <= 2*x+y {
		fmt.Println(z/temp*3 + 2)
		return
	}
	if z%temp > 2*x+y {
		fmt.Println(z/temp*3 + 3)
		return
	}
}
