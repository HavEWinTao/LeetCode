public class Solution {
    /**
     * 很久以前
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        right[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);

        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return ans;
    }

    /**
     * 2022-10-23
     */
    public int trap2(int[] height) {
        int n = height.length;
        int maxHeight = -1;
        for (int j : height) {
            maxHeight = Math.max(maxHeight, j);
        }
        int ans = 0;
        int left = 0;
        int index1;
        for (index1 = 0; index1 < n && height[index1] < maxHeight; index1++) {
            if (height[index1] > left) {
                left = height[index1];
            } else {
                ans += (left - height[index1]);
            }
        }
        int right = 0;
        int index2;
        for (index2 = n - 1; index2 >= 0 && height[index2] < maxHeight; index2--) {
            if (height[index2] > right) {
                right = height[index2];
            } else {
                ans += (right - height[index2]);
            }
        }
        for (int i = index1; i <= index2; i++) {
            ans += maxHeight - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }
}
