import java.util.Stack;

public class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            temp.append(c);
            if (c == '(') {
                stack.add(c);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(temp.substring(1, temp.length() - 1));
                    temp = new StringBuilder();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()())(())(()(()))";
        System.out.println(solution.removeOuterParentheses(s));
    }
}
