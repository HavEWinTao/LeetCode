import java.util.*;

public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (c == temp) {
                while (last <= i) {
                    ans[last] = Math.min(ans[last], i - last);
                    last++;
                }
            }
        }
        last = n - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char temp = s.charAt(i);
            if (c == temp) {
                while (last >= i) {
                    ans[last] = Math.min(ans[last], last - i);
                    last--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.shortestToChar("loveleetcode", 'e')));
    }
}
