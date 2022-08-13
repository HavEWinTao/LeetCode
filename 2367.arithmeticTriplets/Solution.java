public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int index1 = i + 1;
            while (index1 < n - 1 && nums[index1] - nums[i] < diff) {
                index1++;
            }
            if (nums[index1] - nums[i] == diff) {
                int index2 = index1 + 1;
                while (index2 < n && nums[index2] - nums[index1] < diff) {
                    index2++;
                }
                if (index2 < n && nums[index2] - nums[index1] == diff) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
