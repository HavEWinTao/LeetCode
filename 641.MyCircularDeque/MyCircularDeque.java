public class MyCircularDeque {

    private final int size;
    private int p, q;
    private final int[] arr;

    public MyCircularDeque(int k) {
        size = k + 1;
        p = 0;
        q = 0;
        arr = new int[size + 1];
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            p = (p + size - 1) % size;
            arr[p] = value;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            arr[q] = value;
            q = (q + 1) % size;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            p = (p + 1) % size;
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            q = (q + size - 1) % size;
            return true;
        }
        return false;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[p % size];
    }

    public int getRear() {
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
}
