package main

import (
	"fmt"
	"strconv"
	"strings"
)

type LRUCache struct {
	capacity int
	mp       map[int]*Node
	list     *List
}

// Node 双向链表的节点 无头结点
type Node struct {
	key  int
	val  int
	prev *Node
	next *Node
}

type List struct {
	head *Node
	tail *Node
}

// 将node移动到链表的头部，即head后
func (l *List) toFirst(node *Node) {
	l.removeNode(node)
	node.prev = nil
	node.next = nil
	l.addHead(node)
}

// 将node添加到链表的头部，即head后
func (l *List) addHead(node *Node) {
	if l.head == nil { //双向链表还为空
		l.head = node
		l.tail = l.head
		return
	}
	l.head.prev = node
	node.next = l.head
	l.head = node
}

// 移除node
func (l *List) removeNode(node *Node) {
	if node.next == nil && node.prev == nil { // 仅有一个节点
		l.head = nil
		l.tail = nil
		return
	}
	if node.next != nil {
		node.next.prev = node.prev
	} else { // 移除的是最后一个节点
		l.tail = l.tail.prev
		l.tail.next = nil
	}
	if node.prev != nil {
		node.prev.next = node.next
	} else { // 移除的是第一个节点
		l.head = l.head.next
		l.head.prev = nil
	}
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		capacity: capacity,
		mp:       make(map[int]*Node, 0),
		list:     &List{},
	}
}

func (cache *LRUCache) Get(key int) int {
	v, ok := cache.mp[key]
	if !ok {
		return -1
	}
	cache.list.toFirst(v)
	return v.val
}

func (cache *LRUCache) Put(key int, value int) {
	v, ok := cache.mp[key]
	if ok {
		v.val = value
		cache.list.toFirst(v)
		return
	}
	addNode := &Node{
		key: key,
		val: value,
	}
	cache.mp[key] = addNode
	cache.list.addHead(addNode)
	if len(cache.mp) > cache.capacity {
		delete(cache.mp, cache.list.tail.key)
		cache.list.removeNode(cache.list.tail)
	}
}

func main() {
	//genTestCase()
	{
		cache := Constructor(10)
		cache.Put(10, 13)
		cache.Put(3, 17)
		cache.Put(6, 11)
		cache.Put(10, 5)
		cache.Put(9, 10)
		fmt.Printf("%+v\n", cache.Get(13))
		cache.Put(2, 19)
		fmt.Printf("%+v\n", cache.Get(2))
		fmt.Printf("%+v\n", cache.Get(3))
		cache.Put(5, 25)
		fmt.Printf("%+v\n", cache.Get(8))
		cache.Put(9, 22)
		cache.Put(5, 5)
		cache.Put(1, 30)
		fmt.Printf("%+v\n", cache.Get(11))
		cache.Put(9, 12)
		fmt.Printf("%+v\n", cache.Get(7))
		fmt.Printf("%+v\n", cache.Get(5))
		fmt.Printf("%+v\n", cache.Get(8))
		fmt.Printf("%+v\n", cache.Get(9))
		cache.Put(4, 30)
		cache.Put(9, 3)
		fmt.Printf("%+v\n", cache.Get(9))
		fmt.Printf("%+v\n", cache.Get(10))
		fmt.Printf("%+v\n", cache.Get(10))
		cache.Put(6, 14)
		cache.Put(3, 1)
		fmt.Printf("%+v\n", cache.Get(3))
		cache.Put(10, 11)
		fmt.Printf("%+v\n", cache.Get(8))
		cache.Put(2, 14)
		fmt.Printf("%+v\n", cache.Get(1))
		fmt.Printf("%+v\n", cache.Get(5))
		fmt.Printf("%+v\n", cache.Get(4))
		cache.Put(11, 4)
		cache.Put(12, 24)
		cache.Put(5, 18)
		fmt.Printf("%+v\n", cache.Get(13))
		cache.Put(7, 23)
		fmt.Printf("%+v\n", cache.Get(8))
		fmt.Printf("%+v\n", cache.Get(12))
		cache.Put(3, 27)
		cache.Put(2, 12)
		fmt.Printf("%+v\n", cache.Get(5))
		cache.Put(2, 9)
		cache.Put(13, 4)
		cache.Put(8, 18)
		cache.Put(1, 7)
		fmt.Printf("%+v\n", cache.Get(6))
		cache.Put(9, 29)
		cache.Put(8, 21)
		fmt.Printf("%+v\n", cache.Get(5))
		cache.Put(6, 30)
		cache.Put(1, 12)
		fmt.Printf("%+v\n", cache.Get(10))
		cache.Put(4, 15)
		cache.Put(7, 22)
		cache.Put(11, 26)
		cache.Put(8, 17)
		cache.Put(9, 29)
		fmt.Printf("%+v\n", cache.Get(5))
		cache.Put(3, 4)
		cache.Put(11, 30)
		fmt.Printf("%+v\n", cache.Get(12))
		cache.Put(4, 29)
		fmt.Printf("%+v\n", cache.Get(3))
		fmt.Printf("%+v\n", cache.Get(9))
		fmt.Printf("%+v\n", cache.Get(6))
		cache.Put(3, 4)
		fmt.Printf("%+v\n", cache.Get(1))
		fmt.Printf("%+v\n", cache.Get(10))
		cache.Put(3, 29)
		cache.Put(10, 28)
		cache.Put(1, 20)
		cache.Put(11, 13)
		fmt.Printf("%+v\n", cache.Get(3))
		cache.Put(3, 12)
		cache.Put(3, 8)
		cache.Put(10, 9)
		cache.Put(3, 26)
		fmt.Printf("%+v\n", cache.Get(8))
		fmt.Printf("%+v\n", cache.Get(7))
		fmt.Printf("%+v\n", cache.Get(5))
		cache.Put(13, 17)
		cache.Put(2, 27)
		cache.Put(11, 15)
		fmt.Printf("%+v\n", cache.Get(12))
		cache.Put(9, 19)
		cache.Put(2, 15)
		cache.Put(3, 16)
		fmt.Printf("%+v\n", cache.Get(1))
		cache.Put(12, 17)
		cache.Put(9, 1)
		cache.Put(6, 19)
		fmt.Printf("%+v\n", cache.Get(4))
		fmt.Printf("%+v\n", cache.Get(5))
		fmt.Printf("%+v\n", cache.Get(5))
		cache.Put(8, 1)
		cache.Put(11, 7)
		cache.Put(5, 2)
		cache.Put(9, 28)
		fmt.Printf("%+v\n", cache.Get(1))
		cache.Put(2, 2)
		cache.Put(7, 4)
		cache.Put(4, 22)
		cache.Put(7, 24)
		cache.Put(9, 26)
		cache.Put(13, 28)
		cache.Put(11, 26)
	}
	fmt.Println("---------------")
	{
		cache := Constructor(2)
		cache.Put(1, 1)
		cache.Put(2, 2)
		fmt.Printf("%+v\n", cache.Get(1)) // 返回  1
		cache.Put(3, 3)                   // 该操作会使得密钥 2 作废
		fmt.Printf("%+v\n", cache.Get(2)) // 返回 -1 (未找到)
		cache.Put(4, 4)                   // 该操作会使得密钥 1 作废
		fmt.Printf("%+v\n", cache.Get(1)) // 返回 -1 (未找到)
		fmt.Printf("%+v\n", cache.Get(3)) // 返回  3
		fmt.Printf("%+v\n", cache.Get(4)) // 返回  4
	}
	fmt.Println("---------------")
	{
		cache := Constructor(1)
		cache.Put(2, 1)
		fmt.Printf("%+v\n", cache.Get(2)) // 返回  1
	}
	fmt.Println("---------------")
}

func genTestCase() {
	op := `"LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"`
	param := `[[10], [10, 13],[3, 17], [6, 11], [10, 5], [9, 10], [13], [2, 19], [2], [3], [5, 25], [8], [9, 22], [5, 5], [1, 30],[11], [9, 12],[7], [5], [8], [9], [4, 30], [9, 3], [9], [10], [10],[6, 14], [3, 1], [3], [10, 11], [8], [2, 14], [1], [5],[4], [11, 4],[12, 24], [5, 18], [13], [7, 23], [8], [12],[3, 27], [2, 12], [5], [2, 9], [13, 4], [8, 18], [1, 7],[6], [9, 29],[8, 21], [5],[6, 30], [1, 12], [10], [4, 15], [7, 22], [11, 26], [8, 17],[9, 29], [5],[3, 4], [11, 30], [12], [4, 29], [3], [9],[6], [3, 4],[1], [10], [3, 29], [10, 28],[1, 20], [11, 13], [3], [3, 12], [3, 8], [10, 9], [3, 26],[8], [7], [5], [13, 17], [2, 27], [11, 15],[12], [9, 19],[2, 15], [3, 16], [1], [12, 17], [9, 1], [6, 19], [4], [5], [5], [8, 1], [11, 7], [5, 2], [9, 28],[1], [2, 2],[7, 4], [4, 22], [7, 24], [9, 26], [13, 28],[11, 26]]`
	params := strings.Split(param, ",")
	nums := make([]int, 0)
	for _, v := range params {
		v = strings.TrimLeft(v, " ")
		v = strings.TrimLeft(v, "[")
		v = strings.TrimLeft(v, " ")
		v = strings.TrimLeft(v, " ")
		v = strings.TrimRight(v, "]")
		v = strings.TrimLeft(v, " ")
		num, _ := strconv.Atoi(v)
		nums = append(nums, num)
	}
	conTpl := `cache := Constructor(%d)`
	putTpl := `cache.Put(%d, %d)`
	getTpl := `cache.Get(%d)`
	ops := strings.Split(op, ",")

	n := len(ops)
	idx := 0
	for i := 0; i < n; i++ {
		switch ops[i] {
		case `"LRUCache"`:
			{
				fmt.Println(fmt.Sprintf(conTpl, nums[idx]))
				idx++
			}
		case `"put"`:
			{
				fmt.Println(fmt.Sprintf(putTpl, nums[idx], nums[idx+1]))
				idx += 2
			}
		case `"get"`:
			{
				fmt.Println(`fmt.Printf("%+v\n", ` + fmt.Sprintf(getTpl, nums[idx]) + `)`)
				idx++
			}
		}
	}
}
