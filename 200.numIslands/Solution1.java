public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    ans++;
                }
            }
        }
        return ans;
    }

    public int[][] direct = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void dfs(char[][] grid, int x, int y, boolean[][] vis) {
        int m = grid.length;
        int n = grid[0].length;
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int tx = x + direct[i][0];
            int ty = y + direct[i][1];
            if (tx >= 0 && tx < m && ty >= 0 && ty < n) {
                if (grid[tx][ty] == '1' && !vis[tx][ty]) dfs(grid, tx, ty, vis);
            }
        }
    }
}