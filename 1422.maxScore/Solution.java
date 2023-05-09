package src;

public class Solution {
    public int maxScore(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (str[i - 1] == '0') {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = left[i - 1];
            }
        }
        if (str[n - 1] == '1') {
            right[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (str[i] == '1') {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = right[i + 1];
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;
    }
}
