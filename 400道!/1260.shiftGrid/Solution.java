import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        int x = k / n, y = k % n;
        List<List<Integer>> ans = new ArrayList<>(m);
        int[] cap = new int[n];
        for (int i = 0; i < m; i++) {
            List<Integer> temp = Arrays.stream(cap).boxed().collect(Collectors.toList());
            ans.add(temp);
        }
        for (int i = 0; i < m * n; i++) {
            if (x < m && y < n) {
                ans.get(x).set(y++, grid[i / n][i % n]);
                continue;
            }
            if (x < m && y == n) {
                y = 0;
                x++;
                i--;
                continue;
            }
            if (x == m) {
                x = 0;
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1}};
        int k = 100;
        System.out.println(solution.shiftGrid(grid, k));
    }
}
