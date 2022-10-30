public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });
        //dp[i]表示前i份兼职工作可以获得的最大报酬
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //k表示前满足结束时间小于等于第i-1份工作开始时间的最大dp[i]
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + arr[i - 1][2]);
        }
        return dp[n];
    }

    /**
     * right：搜索的右边界
     * target：找到结束时间<=target（开始时间）的最大值
     */
    private int binarySearch(int[][] arr, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}