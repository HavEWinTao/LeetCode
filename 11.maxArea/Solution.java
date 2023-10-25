class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ret = -1;
        while (i < j) {
            ret = Math.max(ret, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return ret;
    }
}