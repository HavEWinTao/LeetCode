import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        //arr是严格单调递增的
        int n = arr.length;
        int ans = 0;
        //key:每个数字  value:数字对应的下标
        Map<Integer, Integer> num2index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            num2index.put(arr[i], i);
        }
        //dp[i][j]为使用arr[i]为斐波那契数列的最后一位，使用arr[j]为倒数第二位时的最长数列长度
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && j + 2 > ans; j--) {
                if (arr[i] - arr[j] >= arr[j]) {
                    break;
                }
                if (num2index.containsKey(arr[i] - arr[j])) {
                    int temp = num2index.get(arr[i] - arr[j]);
                    dp[i][j] = Math.max(3, dp[j][temp] + 1);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
