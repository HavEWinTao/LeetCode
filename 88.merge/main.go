package main

import (
	"fmt"
	"math"
)

func merge(nums1 []int, m int, nums2 []int, n int) {
	i := 0
	j := 0
	nums3 := make([]int, 0)
	k := 0
	for idx := m; idx < m+n; idx++ {
		nums1[idx] = math.MaxInt
	}
	for i < len(nums1) {
		if j == len(nums2) {
			nums3 = append(nums3, nums1[i])
			nums1[i] = nums3[k]
			i++
			k++
			continue
		}
		if k == len(nums3) {
			if nums1[i] <= nums2[j] {
				i++
				continue
			} else {
				nums3 = append(nums3, nums1[i])
				nums1[i] = nums2[j]
				i++
				j++
			}
		} else {
			if nums2[j] < nums3[k] {
				nums3 = append(nums3, nums1[i])
				nums1[i] = nums2[j]
				i++
				j++
			} else {
				nums3 = append(nums3, nums1[i])
				nums1[i] = nums3[k]
				i++
				k++
			}
		}
	}
}

func main() {
	{
		nums1 := []int{1, 2, 3, 0, 0, 0}
		nums2 := []int{2, 5, 6}
		merge(nums1, 3, nums2, 3)
		fmt.Printf("%+v\n", nums1)
	}
	{
		nums1 := []int{2, 0}
		nums2 := []int{1}
		merge(nums1, 1, nums2, 1)
		fmt.Printf("%+v\n", nums1)
	}
}
