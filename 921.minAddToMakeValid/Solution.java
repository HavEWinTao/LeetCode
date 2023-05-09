public class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==')'){
                if (stack.isEmpty()){
                    ans++;
                } else {
                    stack.pop();
                }
            } else {
                stack.add('(');
            }
        }
        return ans + stack.size();
    }
}