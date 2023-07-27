package main

func nextPermutation(nums []int) {
	n := len(nums)
	if n == 1 {
		return
	}
	var i int
	for i = n - 1; i > 1; i-- {
		if nums[i-1] < nums[i] {
			break
		}
	}
	j := i - 1
	for i = n - 1; i > j; i-- {
		if nums[i] > nums[j] {
			break
		}
	}
	nums[i], nums[j] = nums[j], nums[i]
	if i != j {
		j++
	}
	i = n - 1
	for j < i {
		if j < i {
			nums[i], nums[j] = nums[j], nums[i]
			j++
			i--
		}
	}
}
