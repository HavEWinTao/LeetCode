import java.util.*;

public class Solution {
    private int m;
    private int n;

    private final int[][] dirs = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] P = new boolean[m][n];
        boolean[][] A = new boolean[m][n];

        Queue<int[]> queueP = new ArrayDeque<>();
        Queue<int[]> queueA = new ArrayDeque<>();

        for (int j = 0; j < n; j++) {
            P[0][j] = true;
            queueP.add(new int[]{0, j});
            A[m - 1][j] = true;
            queueA.add(new int[]{m - 1, j});
        }

        for (int i = 1; i < m; i++) {
            P[i][0] = true;
            queueP.add(new int[]{i, 0});
            A[i - 1][n - 1] = true;
            queueA.add(new int[]{i - 1, n - 1});
        }

        BFS(queueP, P, heights);
        BFS(queueA, A, heights);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (P[i][j] && A[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, i, j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

    private void BFS(Queue<int[]> queue, boolean[][] run, int[][] heights) {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0], y = temp[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (isValid(nx, ny)) {
                    if (heights[nx][ny] >= heights[x][y]) {
                        if (!run[nx][ny]) {
                            queue.add(new int[]{nx, ny});
                            run[nx][ny] = true;
                        }
                    }
                }
            }
        }
    }

    private boolean isValid(int x, int y) {
        if (x >= 0 && x < m) {
            return y >= 0 && y < n;
        }
        return false;
    }
}
