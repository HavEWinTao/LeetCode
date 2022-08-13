public class Solution {
    public int minStartValue(int[] nums) {
        int ans = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (ans + sum < 1) {
                ans = 1 - sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, -2, -3};
        System.out.println(solution.minStartValue(nums));
    }
}
