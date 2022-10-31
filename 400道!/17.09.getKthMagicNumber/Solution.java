public class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        //dp[i]表示第i个数
        dp[0] = 1;
        // 定义三个 指针，分别表示 resultA、B、C 的下标
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(dp[point3] * 3, dp[point5] * 5), dp[point7] * 7);
            if (resultN % 3 == 0) {
                point3++;
            }
            if (resultN % 5 == 0) {
                point5++;
            }
            if (resultN % 7 == 0) {
                point7++;
            }
            dp[i] = resultN;
        }
        return dp[k - 1];
    }
}