public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, j = 0;//以j结尾的，从i到j的子数组数目为j-i+1
        int sum = 1;
        int n = nums.length;
        int ans = 0;
        while (j < n) {
            sum *= nums[j];
            while (i <= j && sum >= k) {
                sum /= nums[i];
                i++;
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22};
        System.out.println(solution.numSubarrayProductLessThanK(nums, 18));
    }
}
