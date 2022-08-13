class MyCircularQueue {

    private int size;
    private int p, q;
    private int[] arr;

    public MyCircularQueue(int k) {
        size = k + 1;
        p = 0;
        q = 0;
        arr = new int[size + 1];
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            arr[q] = value;
            q = (q + 1) % size;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            p = (p + 1) % size;
            return true;
        }
        return false;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[p % size];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(q + size - 1) % size];
    }

    public boolean isEmpty() {
        return p == q;
    }

    public boolean isFull() {
        return (q + 1) % size == p;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1)); // 返回 true
        System.out.println(queue.enQueue(2)); // 返回 true
        System.out.println(queue.enQueue(3)); // 返回 true
        System.out.println(queue.enQueue(4)); // 返回 false，队列已满
        System.out.println(queue.Rear()); // 返回 3
        System.out.println(queue.isFull()); // 返回 true
        System.out.println(queue.deQueue()); // 返回 true
        System.out.println(queue.enQueue(4)); // 返回 true
        System.out.println(queue.Rear()); // 返回 4
    }
}
