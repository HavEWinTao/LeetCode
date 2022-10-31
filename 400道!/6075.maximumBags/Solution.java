import java.util.Arrays;

public class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] free = new int[n];
        for (int i = 0; i < n; i++) {
            free[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(free);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (additionalRocks - free[i] > 0) {
                ans++;
                additionalRocks -= free[i];
            } else {
                break;
            }
        }
        return ans;
    }
}
