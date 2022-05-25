import java.util.*;

public class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int m, n;

    public int cutOffTree(List<List<Integer>> forest) {
        List<Integer[]> trees = new ArrayList<>();
        m = forest.size();
        n = forest.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    trees.add(new Integer[]{height, i, j});
                }
            }
        }
        trees.sort((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        int ans = 0;
        int startX = 0, startY = 0;
        for (int i = 0; i < trees.size(); i++) {
            int height = trees.get(i)[0];
            int x = trees.get(i)[1], y = trees.get(i)[2];
            int steps = bfs(forest, startX, startY, x, y);
            if (steps == -1) {
                return -1;
            }
            ans += steps;
            startX = x;
            startY = y;
        }
        return ans;
    }

    private int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for (int j = 0; j < 4; ++j) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
