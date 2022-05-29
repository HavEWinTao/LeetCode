import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int right = 0;
        while (right < nums.length && nums[right] != 0) {
            right++;
        }
        if (right == nums.length) {
            return;
        }
        for (int left = right; left < nums.length; left++) {
            if (nums[left] != 0) {
                nums[right] = nums[left];
                right++;
            }
        }
        for (; right < nums.length; right++) {
            nums[right] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums = new int[]{1, 0};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
