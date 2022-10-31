import java.util.Arrays;

public class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[++i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{3, 2, 3, 2, 2, 2};
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(solution.divideArray(nums));
    }
}
