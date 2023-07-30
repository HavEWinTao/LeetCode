package main

import "fmt"

func orangesRotting(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	vis := make([][]bool, m, m)
	orange := 0
	queue := newQueue()
	for i := 0; i < m; i++ {
		vis[i] = make([]bool, n, n)
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				orange++
			}
			if grid[i][j] == 2 {
				vis[i][j] = true
				queue.add(&Point{x: i, y: j})
			}
			if grid[i][j] == 0 {
				vis[i][j] = true
			}
		}
	}
	ret := 0
	for !queue.isEmpty() {
		if orange == 0 {
			break
		}
		ret++
		size := queue.Size()
		for i := 0; i < size; i++ {
			pop := queue.pop()
			for j := 0; j < 4; j++ {
				x := pop.x + direction[j][0]
				y := pop.y + direction[j][1]
				if x < 0 || x == m || y < 0 || y == n {
					continue
				}
				if vis[x][y] == false {
					vis[x][y] = true
					queue.add(&Point{x: x, y: y})
					orange--
				}
			}
		}
	}
	if orange > 0 {
		ret = -1
	}
	return ret
}

var direction = [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}

type Point struct {
	x, y int
}

type Queue struct {
	arr   []*Point
	front int
	tail  int
}

func (q *Queue) Size() int {
	return q.tail - q.front - 1
}

func (q *Queue) add(p *Point) {
	q.arr = append(q.arr, p)
	q.tail++
}

func (q *Queue) pop() *Point {
	q.front++
	return q.arr[q.front]
}

func (q *Queue) isEmpty() bool {
	return q.Size() == 0
}

func newQueue() *Queue {
	return &Queue{
		arr:   make([]*Point, 0),
		front: -1,
		tail:  0,
	}
}

func main() {
	grid := [][]int{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}
	ret := orangesRotting(grid)
	fmt.Printf("%+v\n", ret)
}
