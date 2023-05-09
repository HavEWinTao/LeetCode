import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < n && nums[left] % 2 == 0) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 2};
        System.out.println(Arrays.toString(solution.sortArrayByParity(nums)));
    }
}
