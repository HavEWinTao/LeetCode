package main

func kidsWithCandies(candies []int, extraCandies int) []bool {
	max := -1
	for _, v := range candies {
		max = maxInt(max, v)
	}
	ret := make([]bool, 0, len(candies))
	for _, v := range candies {
		if extraCandies+v >= max {
			ret = append(ret, true)
		} else {
			ret = append(ret, false)
		}
	}
	return ret
}

func maxInt(a, b int) int {
	if a < b {
		return b
	}
	return a
}
