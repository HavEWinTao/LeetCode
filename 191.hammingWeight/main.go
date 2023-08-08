package main

func hammingWeight(num uint32) int {
	var idx uint32
	idx = 1
	ret := 0
	for i := 0; i < 32; i++ {
		if ((idx << i) & num) == (idx << i) {
			ret++
		}
	}
	return ret
}
