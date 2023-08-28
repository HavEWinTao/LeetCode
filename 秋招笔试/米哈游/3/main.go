package main

import (
	"fmt"
	"strings"
)

type Node struct {
	c    byte
	idx  int
	edge []*Node
}

/*
5
mhyhm
1 2
2 3
3 4
4 5
*/
func main() {
	var n int
	fmt.Scan(&n)
	tree := make([]*Node, n+1)
	var str string
	fmt.Scanln(&str)
	fmt.Scanln(&str)
	for i := 1; i <= n; i++ {
		tree[i] = &Node{
			c:    str[i-1],
			idx:  i,
			edge: make([]*Node, 0),
		}
	}
	var u, v int
	for i := 1; i < n; i++ {
		fmt.Scan(&u, &v)
		tree[u].edge = append(tree[u].edge, tree[v])
		tree[v].edge = append(tree[v].edge, tree[u])
	}
	ans := 0
	var dfs func(root *Node, str string, vis []bool)
	dfs = func(root *Node, str string, vis []bool) {
		str += string(root.c)
		vis[root.idx] = true
		ans += strings.Count(str, "mhy")
		for _, next := range root.edge {
			if !vis[next.idx] {
				dfs(next, str, vis)
			}
		}
	}
	for i := 1; i <= n; i++ {
		dfs(tree[i], "", make([]bool, n+1))
	}
	fmt.Println(ans)
}
