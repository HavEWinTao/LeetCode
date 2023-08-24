package main

func countServers(grid [][]int) int {
	allCount := 0
	badCount := 0
	pointA := 0
	//计算总共有多少服务器
	for i := 0; i < len(grid); i++ {
		//行和
		sumC := 0
		//列和
		sumA := 0
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == 1 {
				allCount++
				sumC++
				//记录对应的列的下标
				pointA = j
			}
		}
		if sumC == 1 {
			for k := 0; k < len(grid); k++ {
				//说明该行只有一个服务器
				if grid[k][pointA] == 1 {
					sumA++
				}
			}
			if sumA == 1 {
				badCount++
			}
		}
	}
	return allCount - badCount
}
