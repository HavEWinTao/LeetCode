package main

import (
	"fmt"
	"math/rand"
	"time"
)

func findKthLargest(nums []int, k int) int {
	rand.Seed(time.Now().UnixNano())
	return quickSelect(nums, 0, len(nums)-1, len(nums)-k)
}

func quickSelect(nums []int, left, right, target int) int {
	idx := randomPartition(nums, left, right)
	if idx == target {
		return nums[idx]
	} else if idx < target {
		return quickSelect(nums, idx+1, right, target)
	}
	return quickSelect(nums, left, idx-1, target)
}

func randomPartition(nums []int, left, right int) int {
	r := rand.Int()%(right-left+1) + left
	nums[r], nums[right] = nums[right], nums[r]
	return partition(nums, left, right)
}

func partition(nums []int, left, right int) int {
	i := left
	pivot := nums[right]
	for j := left; j < right; j++ {
		if nums[j] <= pivot {
			nums[i], nums[j] = nums[j], nums[i]
			i++
		}
	}
	nums[i], nums[right] = nums[right], nums[i]
	return i
}

func main() {
	nums := []int{3, 2, 1, 5, 6, 4}
	fmt.Println(findKthLargest(nums, 2))
}
