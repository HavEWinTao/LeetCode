import java.util.Arrays;

public class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        //一共需要走2n-1步
        for (int k = 1; k < 2 * n - 1; k++) {
            //已经走了k步时,x1可能的位置，y1的位置可以由x1和k唯一确定
            for (int x1 = Math.max(k - n + 1, 0); x1 <= Math.min(k, n - 1); x1++) {
                if (grid[x1][k - x1] != -1) {//这个位置不是荆棘，可以走
                    //假设A永远在B上方走，即x1<=x2
                    for (int x2 = x1; x2 <= Math.min(k, n - 1); x2++) {
                        if (grid[x2][k - x2] != -1) {//这个位置不是荆棘，可以走
                            //当前是由上一步怎么走走来的
                            //都向右移动
                            int preStatus = dp[x1][x2][k - 1];
                            //都向下移动
                            if (x1 > 0 && x2 > 0) {
                                preStatus = Math.max(preStatus, dp[x1 - 1][x2 - 1][k - 1]);
                            }
                            //A向下移动，B向右移动
                            if (x1 > 0) {
                                preStatus = Math.max(preStatus, dp[x1 - 1][x2][k - 1]);
                            }
                            //A向右移动，B向下移动
                            if (x2 > 0) {
                                preStatus = Math.max(preStatus, dp[x1][x2 - 1][k - 1]);
                            }
                            preStatus += grid[x1][k - x1];
                            //是否是同一个走到同一个位置，是的话只能加一个
                            if (x1 != x2) {
                                preStatus += grid[x2][k - x2];
                            }
                            dp[x1][x2][k] = preStatus;
                        }
                    }
                }
            }
        }
        return Math.max(dp[n - 1][n - 1][2 * n - 2], 0);
    }
}
