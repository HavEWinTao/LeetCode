public class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                ans = nums[i];
                break;
            }
            if (i < n - 2 && nums[i] == nums[i + 2]) {
                ans = nums[i];
                break;
            }
            if (i < n - 3 && nums[i] == nums[i + 3]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
}
