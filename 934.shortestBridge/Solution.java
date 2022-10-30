import java.util.*;

public class Solution {

    List<Integer[]> list1 = new ArrayList<>();
    List<Integer[]> list2 = new ArrayList<>();

    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int[][] grid;

    boolean[][] visit;

    int n;

    public int shortestBridge(int[][] _grid) {
        n = _grid.length;
        visit = new boolean[n][n];
        grid = _grid;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && grid[i][j] == 1) {
                    BFS(i, j, flag);
                    flag = false;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            Integer[] point1 = list1.get(i);
            for (int j = 0; j < list2.size(); j++) {
                Integer[] point2 = list2.get(j);
                ans = Math.min(ans, calDis(point1[0], point1[1], point2[0], point2[1]));
            }
        }
        return ans;
    }

    private void BFS(int x, int y, boolean flag) {
        List<Integer[]> list = flag ? list1 : list2;
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{x, y});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer[] point = queue.poll();
                list.add(point);
                for (int j = 0; j < direction.length; j++) {
                    int x1 = point[0] + direction[j][0];
                    int y1 = point[1] + direction[j][1];
                    if (isLegal(x1, y1) && (grid[x1][y1] == 1) && !visit[x1][y1]) {
                        queue.add(new Integer[]{x1, y1});
                        visit[x1][y1] = true;
                    }
                }
            }
        }
    }

    private boolean isLegal(int x, int y) {
        if (x < n && y < n && x >= 0 && y >= 0) {
            return true;
        }
        return false;
    }

    private int calDis(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return Math.abs(y1 - y2) - 1;
        }
        if (y1 == y2) {
            return Math.abs(x1 - x2) - 1;
        }
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) - 1;
    }
}