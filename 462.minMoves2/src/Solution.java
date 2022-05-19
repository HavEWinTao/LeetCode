import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        //经过验证，数据长度奇数偶数无所谓
        int n = nums.length;
        int mid = nums[n / 2];
        int ans = 0;
        for (int num : nums) {
            ans += Math.abs(mid - num);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{1, 10, 2, 9};
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.minMoves2(nums));
    }
}
