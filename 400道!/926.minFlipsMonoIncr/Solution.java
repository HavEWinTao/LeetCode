import java.util.Map;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] l = new int[n];
        int[] r = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                temp++;
            }
            l[i] = temp;
        }
        temp = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                temp++;
            }
            r[i] = temp;
            ans = Math.min(l[i] + r[i] - 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "00011000";
        System.out.println(solution.minFlipsMonoIncr(s));
    }
}
