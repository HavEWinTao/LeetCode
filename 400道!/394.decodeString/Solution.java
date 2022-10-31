import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int length = s.length();
        int i = 0;
        while (i < length) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {//加入数字
                StringBuilder num = new StringBuilder();
                while (Character.isDigit(c)) {
                    num.append(c);
                    i++;
                    c = s.charAt(i);
                }
                stack.add(num.toString());
            } else if (c == '[') {
                stack.add(String.valueOf(c));
                i++;
            } else if (Character.isLetter(c)) {
                StringBuilder str = new StringBuilder();
                while (Character.isLetter(c)) {
                    str.append(c);
                    i++;
                    if (i == length) {
                        break;
                    }
                    c = s.charAt(i);
                }
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && !"[".equals(stack.peek())) {
                    temp.append(new StringBuffer(stack.pop()).reverse());
                }
                stack.add(temp.reverse().append(str).toString());
            } else {
                i++;
                String str = stack.pop();
                stack.pop();//弹出[
                StringBuilder merge = new StringBuilder();
                int num = Integer.parseInt(stack.pop());
                while (num-- > 0) {
                    merge.append(str);
                }
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && !"[".equals(stack.peek())) {
                    temp.append(new StringBuffer(stack.pop()).reverse());
                }
                stack.add(temp.reverse().append(merge).toString());
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(s));
    }
}
