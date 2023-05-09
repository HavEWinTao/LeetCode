class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] inc = new int[n];
        for (int i = k + 1; i < n; i++) {
            if (i == k + 1) {
                inc[i] = 1;
                continue;
            }
            if (nums[i] >= nums[i - 1]) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        int[] dec = new int[n];
        for (int i = n - k - 1; i >= 0; i--) {
            if (i == n - k - 1) {
                dec[i] = 1;
                continue;
            }
            if (nums[i] >= nums[i + 1]) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            boolean flag1 = inc[i + k] >= k;
            boolean flag2 = dec[i - k] >= k;
            if (flag1 & flag2) {
                ans.add(i);
            }
        }
        return ans;
    }
}