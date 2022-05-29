import java.util.Map;

public class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);

            ans = Math.max(max, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, -1, 4};
        System.out.println(solution.maxProduct(nums));
    }
}
