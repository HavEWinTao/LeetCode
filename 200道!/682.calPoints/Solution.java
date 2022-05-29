import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            switch (op) {
                case "C": {
                    stack.pop();
                    break;
                }
                case "D": {
                    int temp = stack.peek();
                    stack.push(temp * 2);
                    break;
                }
                case "+": {
                    int temp1 = stack.pop();
                    int temp2 = stack.peek();
                    stack.push(temp1);
                    stack.push(temp1 + temp2);
                    break;
                }
                default: {
                    int score = Integer.parseInt(op);
                    stack.push(score);
                    break;
                }
            }
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
