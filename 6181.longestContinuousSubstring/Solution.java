public class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int ans = 1;
        int temp = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) + 1 == s.charAt(i)) {
                temp++;
            } else {
                ans = Math.max(ans, temp);
                temp = 1;
            }
        }
        return Math.max(ans, temp);
    }
}