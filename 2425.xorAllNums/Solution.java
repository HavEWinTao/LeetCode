public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        int num1 = nums2.length;
        int num2 = nums1.length;
        if (num1 % 2 != 0) {
            for (int j : nums1) {
                ans = ans ^ j;
            }
        }
        if (num2 % 2 != 0) {
            for (int j : nums2) {
                ans = ans ^ j;
            }
        }
        return ans;
    }
}