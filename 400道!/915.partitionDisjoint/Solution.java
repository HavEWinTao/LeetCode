public class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minVal = new int[n];
        minVal[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minVal[i] = Math.min(minVal[i + 1], nums[i]);
        }
        int temp = nums[0];
        for (int i = 1; i < n; i++) {

            if (temp <= minVal[i]) {
                return i;
            }
            temp = Math.max(temp, nums[i]);
        }
        return -1;
    }
}