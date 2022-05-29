public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 1 && n == 1) {
            return matrix[0][0] == target;
        }
        int i = 0, j = 0;
        int rowBound = m - 1;
        int colBound = n - 1;
        while (i <= rowBound && j <= colBound) {
            if (target > matrix[i][colBound]) {
                i++;
                continue;
            }
            if (target > matrix[rowBound][j]) {
                j++;
                continue;
            }
            while (colBound > j && matrix[i][colBound] > target) {
                colBound--;
            }
            while (rowBound > i && matrix[rowBound][j] > target) {
                rowBound--;
            }
            if (i == rowBound && j == colBound) {
                return matrix[rowBound][colBound] == target;
            } else if (matrix[rowBound][j] == target) {
                return true;
            } else if (matrix[i][colBound] == target) {
                return true;
            }
        }
        if (i >= m || j >= n) {
            return false;
        } else {
            return matrix[i][j] == target;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                //{1, 4, 7, 11, 15},
                //{2, 5, 8, 12, 19},
                //{3, 6, 9, 16, 22},
                //{10, 13, 14, 17, 24},
                //{18, 21, 23, 26, 30}
                //{-1, 3}
                //{-5}
                //{1, 1}
                {5, 6, 9},
                {9, 10, 11},
                {11, 14, 18}
        };

        System.out.println(solution.searchMatrix(matrix, 9));
    }
}
