class MinStack {
    int size;
    int[] data;
    int[] min;

    public MinStack() {
        min = new int[100000];
        size = 0;
        data = new int[100000];
    }

    public void push(int val) {
        if (size == 0) {
            data[size] = val;
            min[size] = val;
        } else {
            data[size] = val;
            min[size] = Math.min(val, min[size - 1]);
        }
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[size - 1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}

