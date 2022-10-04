public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        //dp[i]表示第i个数
        dp[0] = 1;
        // 定义三个 指针，分别表示 resultA、B、C 的下标
        int point2 = 0;
        int point3 = 0;
        int point5 = 0;
        for (int i = 1; i < n; i++) {
            int resultN = Math.min(Math.min(dp[point2] * 2, dp[point3] * 3), dp[point5] * 5);
            if (resultN % 2 == 0) {
                point2++;
            }
            if (resultN % 3 == 0) {
                point3++;
            }
            if (resultN % 5 == 0) {
                point5++;
            }
            dp[i] = resultN;
        }
        return dp[n - 1];
    }
}