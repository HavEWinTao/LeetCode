public class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    DFS(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void DFS(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if (isVaild(grid, x - 1, y) && grid[x - 1][y] == '1') {
            DFS(grid, x - 1, y);
        }
        if (isVaild(grid, x + 1, y) && grid[x + 1][y] == '1') {
            DFS(grid, x + 1, y);
        }
        if (isVaild(grid, x, y + 1) && grid[x][y + 1] == '1') {
            DFS(grid, x, y + 1);
        }
        if (isVaild(grid, x, y - 1) && grid[x][y - 1] == '1') {
            DFS(grid, x, y - 1);
        }
    }

    public boolean isVaild(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return false;
        }
        if (y < 0 || y >= grid[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }
}
