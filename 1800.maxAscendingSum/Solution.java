public class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int temp = 0;
        ans = temp = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                temp += nums[i];
            } else {
                temp = nums[i];
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}