import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int ans = 0;
        int m = nums.length;
        int n = numsDivide.length;
        Arrays.sort(nums);
        int index = 0;
        while (index < m) {
            int mod = nums[index];
            int j = 0;
            while (j < n && numsDivide[j] % mod == 0) {
                j++;
            }
            if (j == n) {
                return ans;
            }
            while (index < m && nums[index] == mod) {
                index++;
                ans++;
            }
        }
        return -1;
    }
}
