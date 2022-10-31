public class Solution {

    private char[] s;

    private int[][] dp;

    public int findIntegers(int n) {
        s = Integer.toBinaryString(n).toCharArray();
        int m = s.length;
        dp = new int[m][2];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false) + 1;
    }

    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][(mask & (1 << (i - 1))) != 0 ? 1 : 0] != -1) {
            return dp[i][(mask & (1 << (i - 1))) != 0 ? 1 : 0];
        }
        int res = 0;
        if (!isNum) {
            res += f(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 1;
        for (int d = isNum ? 0 : 1; d <= up; ++d) {
            //第i-1位是0
            if (d == 1) {
                if (((1 << i - 1) & mask) == 0) {
                    res += f(i + 1, mask | (1 << i), isLimit && d == up, true);
                }
            }
            if (d == 0) {
                res += f(i + 1, mask, isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][(mask & (1 << (i - 1))) != 0 ? 1 : 0] = res;
        }
        return res;
    }
}