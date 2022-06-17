import java.util.Arrays;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        int flag = 1;
        int i = 0, j = 0;
        while (true) {
            ans[index++] = mat[i][j];
            if (i == m-1 && j == n-1) {
                break;
            }
            i += -1 * flag;
            j += flag;
            if (i < 0 || j == n) {
                if (i < 0 && j == n) {
                    i = 1;
                    j = n - 1;
                } else if (i < 0) {
                    i = 0;
                } else {
                    i += 2;
                    j = n - 1;
                }
                flag *= -1;
            }
            if (i == m || j < 0) {
                if (i == m && j < 0) {
                    i = m - 1;
                    j = 1;
                } else if (i == m) {
                    i = m - 1;
                    j += 2;
                } else {
                    j = 0;
                }
                flag *= -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(solution.findDiagonalOrder(mat)));
    }
}
