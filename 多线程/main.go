package main

import (
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

func producer(ch chan<- int) {
	for i := 0; i < 100; i++ {
		ch <- i
		fmt.Printf("生产者生产：%d\n", i)
		time.Sleep(time.Millisecond * 500)
	}
	close(ch)
}

func consumer(i int, ch <-chan int) {
	for num := range ch {
		fmt.Printf("消费者【%d】消费：%d\n", i, num)
	}
	wg.Done()
}

func main() {
	ch := make(chan int, 100)
	go producer(ch)
	wg = sync.WaitGroup{}
	wg.Add(3)
	for i := 1; i <= 3; i++ {
		go consumer(i, ch)
	}
	wg.Wait()
	fmt.Printf("消费完成\n")
}
