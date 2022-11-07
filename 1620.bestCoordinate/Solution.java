public class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        for (int[] tower : towers) {
            left = Math.min(left, tower[0]);
            right = Math.max(right, tower[0]);
            top = Math.max(top, tower[1]);
            bottom = Math.min(bottom, tower[1]);
        }
        int[][] grid = new int[51][51];
        for (int[] tower : towers) {
            for (int j = left; j <= right; j++) {
                for (int k = bottom; k <= top; k++) {
                    if (isIn(tower[0], tower[1], j, k, radius)) {
                        grid[j][k] += tower[2] / (1 + calDis(tower[0], tower[1], j, k));
                    }
                }
            }
        }
        int x = 0, y = 0;
        int max = -1;
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x, y};
    }

    private double calDis(int x1, int y1, int x2, int y2) {
        double temp = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
        return Math.sqrt(temp);
    }

    private boolean isIn(int x1, int y1, int x2, int y2, int r) {
        int dis = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return dis <= Math.pow(r, 2);
    }
}