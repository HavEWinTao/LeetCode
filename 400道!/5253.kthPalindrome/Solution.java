import java.util.Arrays;

public class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long base = (long) Math.pow(10, (intLength - 1) / 2);
        long[] ans = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            if ((long) q > (long) 9 * Math.pow(10, (intLength - 1) / 2)) {
                ans[i] = -1;
                continue;
            }
            long num = base + q - 1;
            String str = String.valueOf(num);
            StringBuilder sb = new StringBuilder(str);
            if (intLength % 2 == 0) {
                str += sb.reverse().toString();
            } else {
                str = str + sb.reverse().substring(1);
            }
            ans[i] = Long.parseLong(str);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] queries = new int[]{493903904};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.kthPalindrome(queries, 15)));
    }
}
