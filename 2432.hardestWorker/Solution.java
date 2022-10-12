public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int ans = n;
        int time = 0;
        int maxTime = 0;
        for (int[] log : logs) {
            if (log[1] - time > maxTime) {
                maxTime = log[1] - time;
                ans = log[0];
            } else if (log[1] - time == maxTime) {
                ans = Math.min(ans, log[0]);
            }
            time = log[1];
        }
        return ans;
    }
}