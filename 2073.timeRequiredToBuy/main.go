package main

func timeRequiredToBuy(tickets []int, k int) int {
	pivot := tickets[k]
	ret := 0
	for i, v := range tickets {
		if v < pivot {
			ret += v
			continue
		}
		if i <= k {
			ret += pivot
		} else if i > k {
			ret += pivot - 1
		}
	}
	return ret
}
