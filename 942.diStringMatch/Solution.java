import java.util.Arrays;

public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int max = n, min = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = min++;
            }
            if (s.charAt(i) == 'D') {
                ans[i] = max--;
            }
        }
        ans[n] = max;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
    }
}
