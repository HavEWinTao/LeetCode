public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            if (ans > max) {
                max = ans;
            }
            if (ans < 0) {
                ans = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
