class Solution {
    int[] nums;
    int n, t, k;

    public boolean canPartitionKSubsets(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        int tot = 0;
        for (int x : nums) tot += x;
        if (tot % k != 0) return false; // 可行性剪枝
        Arrays.sort(nums);
        n = nums.length;
        t = tot / k;
        return dfs(n - 1, 0, 0, new boolean[n]);
    }

    boolean dfs(int idx, int cur, int cnt, boolean[] vis) {
        if (cnt == k) return true;
        if (cur == t) return dfs(n - 1, 0, cnt + 1, vis);
        for (int i = idx; i >= 0; i--) {  // 顺序性剪枝
            if (vis[i] || cur + nums[i] > t) continue;  // 可行性剪枝
            vis[i] = true;
            if (dfs(i - 1, cur + nums[i], cnt, vis)) return true;
            vis[i] = false;
            if (cur == 0) return false; // 可行性剪枝
        }
        return false;
    }
}