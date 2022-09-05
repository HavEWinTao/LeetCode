import java.util.*;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int index1 = 0, index2 = 0;
        while (index1 < n) {
            stack.add(pushed[index1++]);
            while (!stack.isEmpty() && stack.peek() == popped[index2]) {
                stack.pop();
                index2++;
            }

        }
        while (!stack.isEmpty() && stack.peek() == popped[index2]) {
            stack.pop();
            index2++;
        }
        return stack.isEmpty();
    }
}