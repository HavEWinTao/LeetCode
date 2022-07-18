import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

    private int size;

    private Deque<Integer> deque;

    private int sum;

    public MovingAverage(int size) {
        this.sum = 0;
        this.size = size;
        this.deque = new ArrayDeque<>(size);
    }

    public double next(int val) {

        if (deque.size() == size) {
            int temp = deque.removeFirst();
            sum -= temp;
        }
        deque.addLast(val);
        sum += val;
        int cnt = deque.size() == size ? size : deque.size();
        return (double) sum / cnt;
    }
}
