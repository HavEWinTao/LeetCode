public class Solution {
    public int numSquares(int n) {
        int max = (int) Math.sqrt(n) + 1;
        int[] sqrt = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            sqrt[i] = i * i;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; sqrt[j] <= i; j++) {
                //我也想到了dp[i-j*j]
                min = Math.min(min, dp[i - sqrt[j]]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
