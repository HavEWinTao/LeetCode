package main

import "strings"

func findReplaceString(s string, indices []int, sources, targets []string) string {
	n := len(s)
	replaceStr := make([]string, n)
	replaceLen := make([]int, n)
	for i, idx := range indices {
		if strings.HasPrefix(s[idx:], sources[i]) {
			replaceStr[idx] = targets[i]      // 替换后的字符串
			replaceLen[idx] = len(sources[i]) // 被替换的长度
		}
	}
	ans := &strings.Builder{}
	for i := 0; i < n; {
		if replaceStr[i] == "" {
			ans.WriteByte(s[i])
			i++
		} else {
			ans.WriteString(replaceStr[i])
			i += replaceLen[i]
		}
	}
	return ans.String()
}
