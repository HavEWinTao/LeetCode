public class Solution {
    private int[][] _grid;

    private int n;

    public int equalPairs(int[][] grid) {
        _grid = grid;
        n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (judge(i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean judge(int row, int col) {
        for (int i = 0; i < n; i++) {
            if (_grid[row][i] != _grid[i][col]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(solution.equalPairs(grid));
    }
}
