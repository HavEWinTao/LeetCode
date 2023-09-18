import java.util.*;

public class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        if (row == 1 && col == 1) {
            return 0;
        }
        Deque<int[]> queue = new LinkedList<>();
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) visited[i][j] = -1;
        }

        queue.offerLast(new int[]{0, 0, k});
        visited[0][0] = k;
        int step = 0;

        while (!queue.isEmpty()) {
            int currSize = queue.size();
            step++;
            for (int i = 0; i < currSize; ++i) {
                int[] currPos = queue.pollFirst();

                for (int j = 0; j < 4; ++j) {
                    int nx = currPos[0] + dirs[j][0];
                    int ny = currPos[1] + dirs[j][1];
                    int currK = currPos[2];
                    // 保证下一步的位置在矩阵中
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        // 判断是否到达右下角
                        // 题目中明确了 grid[0][0] == grid[m-1][n-1] == 0，若目标点可以为1，需要修改此部分
                        if (nx == row - 1 && ny == col - 1) {
                            return step;
                        }
                        if (grid[nx][ny] == 1) currK--;

                        if (currK >= 0) {
                            if (visited[nx][ny] == -1 ||
                                    (visited[nx][ny] != -1 && currK > visited[nx][ny])) {//走到相同节点，消除次数更少，能再次进入queue
                                queue.offerLast(new int[]{nx, ny, currK});
                                visited[nx][ny] = currK;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
        }
    }
}