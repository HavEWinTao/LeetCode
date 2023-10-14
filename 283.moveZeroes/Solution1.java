public class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            if (nums[j] != 0) nums[i++] = nums[j++];
            else j++;
        }
        while (i < n) nums[i++] = 0;
    }
}