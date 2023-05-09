import java.util.*;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] arr = new int[]{4,3,2,1,0};
        System.out.println(solution.maxChunksToSorted(arr));
    }
}