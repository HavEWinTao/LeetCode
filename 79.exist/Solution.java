import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    private int[][] directions;

    public boolean exist(char[][] board, String word) {
        directions = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    Point point = new Point(i, j, 1);
                    if (search(board, word, point, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, Point point, boolean[][] visited) {
        if (point.length == word.length()) {
            return true;
        }
        for (int i = 0; i < directions.length; i++) {
            if (pointIsValid(board, point, directions[i])) {
                int x = point.x + directions[i][0];
                int y = point.y + directions[i][1];
                if (board[x][y] == word.charAt(point.length)) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        if (search(board, word, new Point(x, y, point.length + 1), visited)) {
                            return true;
                        }
                        visited[x][y] = false;
                    }
                }
            }
        }
        return false;
    }

    public boolean pointIsValid(char[][] board, Point point, int[] direction) {
        if (point.x + direction[0] >= 0 && point.x + direction[0] < board.length) {
            if (point.y + direction[1] >= 0 && point.y + direction[1] < board[0].length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //char[][] board = new char[][]{
        //        {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        //};
        //String word = "ABCCED";
        char[][] board = new char[][]{
                {'a', 'a'}
        };
        String word = "aaa";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
}

class Point {
    public int x;
    public int y;
    public int length;

    public Point(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
}