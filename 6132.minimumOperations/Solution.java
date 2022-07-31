import java.util.Arrays;

public class Solution {
    public int minimumOperations(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int index = 0;
        int ans = 0;
        while (nums[length - 1] > 0) {
            while (index < nums.length && nums[index] == 0) {
                index++;
            }
            int val = nums[index];
            for (int i = index; i < length; i++) {
                nums[i] -= val;
            }
            index++;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(solution.minimumOperations(nums));
    }
}
