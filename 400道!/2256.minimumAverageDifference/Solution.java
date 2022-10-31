public class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = nums[i] + left[i - 1];
        }
        right[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] + right[i + 1];
        }
        int ans = 0;
        double differ = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = left[i] / (i + 1);
            int b;
            if (i == n - 1) {
                b = 0;
            } else b = right[i] / (n - i - 1);
            if (Math.abs(a - b) < differ) {
                differ = Math.abs(a - b);
                ans = i;
            }
        }
        return ans;
    }
}