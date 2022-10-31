import java.util.Arrays;

public class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length) {
            int min = nums[index];
            while (index < n && nums[index] - min <= k) {
                index++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{16, 8, 17, 0, 3, 17, 8, 20};
        System.out.println(solution.partitionArray(nums, 10));
    }
}
