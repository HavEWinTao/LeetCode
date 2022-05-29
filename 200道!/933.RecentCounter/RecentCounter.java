import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class RecentCounter {

    private Queue<Integer> info;

    public RecentCounter() {
        info = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!info.isEmpty() && (t - info.peek()) > 3000) {
            info.poll();
        }
        info.offer(t);
        return info.size();
    }
}
