import java.util.*;

public class Solution {

    public boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!mp.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (stack.peek() != mp.get(c)) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}