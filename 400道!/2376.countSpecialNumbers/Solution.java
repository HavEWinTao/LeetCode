public class Solution {
    char[] s;
    int[][] dp;

    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        //第二维是一个mask，mask每一位，1100001000表示3,8,9已经被使用了
        dp = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    /**
     * 本质上是一个DFS
     */
    int f(int i, int mask, boolean isLimit, boolean isNum) {
        //能够走到最后一位就说明正确的个数+1
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        //记忆化搜索
        if (!isLimit && isNum && dp[i][mask] >= 0) {
            return dp[i][mask];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, mask, false, false);
        }
        // 枚举要填入的数字 d
        for (int d = isNum ? 0 : 1, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) {
            // d 不在 mask 中
            if ((mask >> d & 1) == 0) {
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][mask] = res;
        }
        return res;
    }
}