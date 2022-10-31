public class Solution {
    public int projectionArea(int[][] grid) {
        //n*n的网格，所以可以做优化
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int maxY = 0, maxZ = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    ans++;
                }
                maxY = Math.max(maxY, grid[i][j]);
                maxZ = Math.max(maxZ, grid[j][i]);
            }
            ans += maxY;
            ans += maxZ;

        }
        return ans;
    }
}
