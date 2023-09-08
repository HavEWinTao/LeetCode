package main

import (
	"fmt"
	"sort"
	"strings"
)

/*
10
KPZOKNSTGLUNPPDKPFFW
NDPKU
KPFFWN
CCHXNNY
GWSGZ
NNYCCHX
FMVKSOHOPGZWG
SGZNNYCC
PKUFMVKSOHOPG
CCSGZN
*/
func main() {
	var n int
	fmt.Scan(&n)
	fmt.Scanln()
	strs := make([]string, n)
	pre := make([]map[string]struct{}, 21)
	for i := 0; i < 21; i++ {
		pre[i] = make(map[string]struct{}, 0)
	}
	pst := make([]map[string]struct{}, 21)
	for i := 0; i < 21; i++ {
		pst[i] = make(map[string]struct{}, 0)
	}
	for i := 0; i < n; i++ {
		fmt.Scan(&strs[i])
		length := len(strs[i])
		for j := 1; j < length-1; j++ { //笔试时应该是边界条件写错了
			pre[j][strs[i][:j]] = struct{}{}
			pst[length-j][strs[i][j:]] = struct{}{}
		}
	}
	ans := make([]string, 0)
	for i := 0; i < n; i++ {
		temp := strs[i]
		length := len(temp)
		for j := 1; j < length; j++ {
			if _, ok1 := pst[j][temp[:j]]; ok1 {
				if _, ok2 := pre[length-j][temp[j:]]; ok2 {
					ans = append(ans, temp)
					break
				}
			}
		}
	}
	sort.Slice(ans, func(i, j int) bool {
		return strings.Compare(ans[i], ans[j]) < 0
	})
	fmt.Println(len(ans))
	for i := 0; i < len(ans); i++ {
		fmt.Println(ans[i])
	}
}
