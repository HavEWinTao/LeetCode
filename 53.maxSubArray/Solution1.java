public class Solution {

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            if (temp <= 0) temp = num;
            else temp += num;
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
            int ans = solution.maxSubArray(nums);
            System.out.println(ans);
        }
    }
}