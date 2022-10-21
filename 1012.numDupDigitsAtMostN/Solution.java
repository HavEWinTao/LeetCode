public class Solution {
    private char[] s;

    private int[][] dp;

    /**
    * 至少有一位重复的数字<----->n-一位重复都没有的数字
    */
    public int numDupDigitsAtMostN(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return n - f(0, 0, true, false);
    }

    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int res = 0;
        if (!isNum) {
            res += f(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; ++d) {
            //d目前还没出现过
            if ((1 << d & mask) == 0) {
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][mask] = res;
        }
        return res;
    }
}