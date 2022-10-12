public class Solution {
     public int scoreOfParentheses(String s) {
        int n = s.length();
        int ans = 0;
        int left = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                left--;
                if (left == 0) {
                    ans += getScore(s.substring(index, i + 1));
                    index = i + 1;
                }
            }
        }
        return ans;
    }

    private int getScore(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int n = s.length();
        return 2 * scoreOfParentheses(s.substring(1, n - 1));
    }
}