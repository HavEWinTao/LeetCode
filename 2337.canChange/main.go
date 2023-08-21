package main

import "strings"

func canChange(start, target string) bool {
	if strings.ReplaceAll(start, "_", "") != strings.ReplaceAll(target, "_", "") {
		return false
	}
	j := 0
	for i, c := range start {
		if c != '_' {
			for target[j] == '_' {
				j++
			}
			if c == 'L' && i < j {
				return false
			}
			if c == 'R' && i > j {
				return false
			}
			j++
		}
	}
	return true
}
