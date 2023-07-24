package main

import "fmt"

func numJewelsInStones(jewels string, stones string) int {
	mp := make(map[int32]struct{})
	for _, c := range jewels {
		mp[c] = struct{}{}
	}
	ret := 0
	for _, c := range stones {
		if _, ok := mp[c]; ok {
			ret++
		}
	}
	return ret
}

func main() {
	jewels := "aA"
	stones := "aAAbbbb"
	fmt.Printf("%+v\n", numJewelsInStones(jewels, stones))
}
