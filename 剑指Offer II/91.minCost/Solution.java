import java.util.Arrays;

public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        for (int j = 0; j < 3; j++) {
            dp[j] = costs[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] dpNew = new int[3];
            for (int j = 0; j < 3; j++) {
                //第i号房子和第i-1号房子的颜色必须不同，因此当第i号房子被粉刷成某一种颜色时，第i−1号房子只能被粉刷成另外两种颜色之一。
                //当第i号房子分别被粉刷成三种颜色时，粉刷第0号房子到第i号房子的最小花费成本计算如下：
                //dp[i][0]=min(dp[i−1][1],dp[i−1][2])+costs[i][0]
                //dp[i][1]=min(dp[i−1][0],dp[i−1][2])+costs[i][1]
                //dp[i][2]=min(dp[i−1][0],dp[i−1][1])+costs[i][2]
                //三种颜色的情况可以合并为一个状态转移方程，对于1<=i<n和0<=j<3，状态转移方程如下：
                //dp[i][j]=min(dp[i−1][(j+1)mod3],dp[i−1][(j+2)mod3])+costs[i][j]
                //计算结束时，dp[n−1]中的最小值即为粉刷所有房子的最小花费成本。
                //当i>=1时，由于dp[i]的计算只和dp[i−1]有关，因此可以使用滚动数组优化空间，将空间复杂度降低到O(1)
                dpNew[j] = Math.min(dp[(j + 1) % 3], dp[(j + 2) % 3]) + costs[i][j];
            }
            dp = dpNew;
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
