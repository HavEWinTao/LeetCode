public class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int ans = 0;
        int MaxHight = height[n - 1];
        for (int i = height.length - 2; i > 0; i--) {
            ans = ans + Math.max(0, Math.min(MaxHight, left[i - 1]) - height[i]);
            MaxHight = Math.max(MaxHight, height[i]);
        }
        return ans;
    }
}