package main

import "fmt"

func canPlaceFlowers(flowerbed []int, n int) bool {
	flowerbed = append(flowerbed, 0)
	flowerbed = append([]int{0}, flowerbed...)
	ret := 0
	for i := 1; i < len(flowerbed)-1; i++ {
		if flowerbed[i] != 1 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0 {
			ret++
			flowerbed[i] = 1
		}
	}
	return ret >= n
}

func main() {
	flowerbed := []int{1, 0, 0, 0, 1}
	n := 1
	fmt.Printf("%+v\n", canPlaceFlowers(flowerbed, n))
}
