public class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i] + dp[i - 1] * 2) % MOD;
            dp[i] = (dp[i] + dp[i - 3]) % MOD;
        }
        return dp[n];
    }
}