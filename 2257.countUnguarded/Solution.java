import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int guardsSize = guards.length;
        int wallsSize = walls.length;
        int size = guardsSize + wallsSize;
        int[][] row = new int[size][3];
        int[][] col = new int[size][3];
        for (int i = 0; i < size; i++) {
            if (i < guardsSize) {
                row[i][0] = col[i][0] = guards[i][0];
                row[i][1] = col[i][1] = guards[i][1];
                row[i][2] = col[i][2] = 1;
            } else {
                row[i][0] = col[i][0] = walls[i - guardsSize][0];
                row[i][1] = col[i][1] = walls[i - guardsSize][1];
            }
        }
        Arrays.sort(row, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        Arrays.sort(col, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        Arrays.sort(guards, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        boolean[][] visit = new boolean[m][n];
        int view = 0;
        for (int i = 0; i < row.length; i++) {
            int[] guard = row[i];
            int x = guard[0];
            int y = guard[1];
            if (guard[2] == 0) {
                continue;
            }
            int right = i + 1;
            int rightBound;
            if (right == size) {
                rightBound = n;
            } else {
                if (x != row[right][0]) {
                    rightBound = n;
                } else {
                    rightBound = row[right][1];
                }
            }
            for (int j = y + 1; j < rightBound; j++) {
                if (!visit[x][j]) {
                    view++;
                    visit[x][j] = true;
                }
            }

            int left = i - 1;
            int leftBound;
            if (left == -1) {
                leftBound = -1;
            } else {
                if (x != row[left][0]) {
                    leftBound = -1;
                } else {
                    leftBound = row[left][1];
                }
            }
            for (int j = y - 1; j > leftBound; j--) {
                if (!visit[x][j]) {
                    view++;
                    visit[x][j] = true;
                }
            }
            //System.out.println(""+x+y+view);
        }

        for (int i = 0; i < col.length; i++) {
            int[] guard = col[i];
            int x = guard[0];
            int y = guard[1];
            if (guard[2] == 0) {
                continue;
            }
            int down = i + 1;
            int downBound;
            if (down == size) {
                downBound = m;
            } else {
                if (y != col[down][1]) {
                    downBound = m;
                } else {
                    downBound = col[down][0];
                }
            }
            for (int j = x + 1; j < downBound; j++) {
                if (!visit[j][y]) {
                    view++;
                    visit[j][y] = true;
                }
            }

            int up = i - 1;
            int upBound;
            if (up == -1) {
                upBound = -1;
            } else {
                if (y != col[up][1]) {
                    upBound = -1;
                } else {
                    upBound = col[up][0];
                }
            }
            for (int j = x - 1; j > upBound; j--) {
                if (!visit[j][y]) {
                    view++;
                    visit[j][y] = true;
                }
            }
            //System.out.println(""+x+y+view);
        }

        return m * n - view - size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] guards = new int[][]{
                //{0, 0}, {1, 1}, {2, 3}
                //{{1, 1}}
                {1, 5}, {1, 1}, {1, 6}, {0, 2}
        };
        int[][] walls = new int[][]{
                //{0, 1}, {2, 2}, {1, 4}
                //{0, 1}, {1, 0}, {2, 1}, {1, 2}
                {0, 6}, {0, 3}, {0, 5}
        };
        System.out.println(solution.countUnguarded(2, 7, guards, walls));
    }
}
