import java.util.Arrays;

public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        //(sum-neg)-neg=sum-2*neg=target
        int sum = Arrays.stream(nums).sum();
        if (sum - target < 0 || (sum - target) % 2 == 1) {
            return 0;
        }
        //dp[i][j]表示在数组nums的前i个数中选取元素，使得这些元素之和等于j的方案
        int neg = (sum - target) / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
