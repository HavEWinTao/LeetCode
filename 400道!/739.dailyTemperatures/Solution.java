import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < n; i++) {
            do {
                int index = stack.peek();
                int top = temperatures[index];
                if (temperatures[i] > top) {
                    ans[index] = i - index;
                    stack.pop();
                } else {
                    break;
                }
            } while (!stack.isEmpty());
            stack.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
}
