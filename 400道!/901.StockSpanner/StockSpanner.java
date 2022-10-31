import java.util.*;

public class StockSpanner {
    private Stack<Integer[]> stack;

    private int idx;

    public StockSpanner() {
        stack = new Stack<>();
        stack.add(new Integer[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    //为什么使用单调栈呢
    //对于某个位置的数，他的下一个数如果比他大就他可以弹出，然后继续向左判断
    //如果他的下一个数比他小那就是直接返回1
    public int next(int price) {
        idx++;//idx表示数的个数
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new Integer[]{idx, price});
        return ret;
    }
}