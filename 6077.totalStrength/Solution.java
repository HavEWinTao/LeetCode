import java.util.Arrays;

//TLE
public class Solution {
    int mod = (int) (1e9 + 7);

    public int totalStrength(int[] strength) {
        int n = strength.length;
        long[] dp = new long[n];
        dp[0] = (long) strength[0] * strength[0];
        for (int i = 1; i < n; i++) {
            //dp[i] = (dp[i] + ((long) strength[i] * (long) strength[i]) % mod) % mod;
            dp[i] = (dp[i] + dp[i - 1]) % mod;
            long min = strength[i];
            long sum = 0;
            for (int j = i; j >= 0; j--) {
                sum = (sum + strength[j]) % mod;
                if (strength[j] < min) {
                    min = strength[j];
                }
                dp[i] = (dp[i] + min * sum) % mod;
            }
        }
        return (int) (dp[n - 1] % mod);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] strength = new int[]{1, 3, 1, 2};
        //{1, 3, 1, 2};
        System.out.println(solution.totalStrength(strength));
    }
}
