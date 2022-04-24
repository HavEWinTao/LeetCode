public class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int dp = 0;
        for (int i = 0; i < n; i++) {
            dp += i * nums[i];
        }
        int ans = dp;
        for (int i = 1; i < n; i++) {
            dp = dp + sum - n * nums[n - i];
            if (dp > ans) {
                ans = dp;
            }
        }
        return ans;
    }
}
