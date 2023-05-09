public class Solution {
    public int orderOfLargestPlusSign(int n, int[][] _mines) {
        int[][] mines = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mines[i], 1);
        }
        for (int[] point : _mines) {
            mines[point[0]][point[1]] = 0;
        }
        //上下左右
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            dp[i][0][2] = 0;
            for (int j = 1; j < n; j++) {
                if (mines[i][j] == 1 && mines[i][j - 1] == 1) {
                    dp[i][j][2] = dp[i][j - 1][2] + 1;
                } else {
                    dp[i][j][2] = 0;
                }
            }
            dp[i][n - 1][3] = 0;
            for (int j = n - 2; j >= 0; j--) {
                if (mines[i][j] == 1 && mines[i][j + 1] == 1) {
                    dp[i][j][3] = dp[i][j + 1][3] + 1;
                } else {
                    dp[i][j][3] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            dp[0][j][0] = 0;
            for (int i = 1; i < n; i++) {
                if (mines[i][j] == 1 && mines[i - 1][j] == 1) {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                } else {
                    dp[i][j][0] = 0;
                }
            }
            dp[n - 1][j][1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (mines[i][j] == 1 && mines[i + 1][j] == 1) {
                    dp[i][j][1] = dp[i + 1][j][1] + 1;
                } else {
                    dp[i][j][1] = 0;
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j] == 1) {
                    int temp = Math.min(dp[i][j][0], dp[i][j][1]);
                    temp = Math.min(temp, dp[i][j][2]);
                    temp = Math.min(temp, dp[i][j][3]);
                    ans = Math.max(ans, temp);
                }
            }
        }
        return ans + 1;
    }
}