public class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[]{0,nums[0]};
        for (int i=1;i<n;i++){
            int[] f = new int[2];
            f[1] = dp[0] + nums[i];
            f[0] = Math.max(dp[1],dp[0]);
            dp = f;
        }
        return Math.max(dp[0],dp[1]);
    }
}
