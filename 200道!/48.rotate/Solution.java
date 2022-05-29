public class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < (size - i - 1); j++) {
                //(i,j)
                int x = i;
                int y = j;
                int last = matrix[x][y];
                for (int k = 0; k < 4; k++) {
                    int tempX = x;
                    x = y;
                    y = size - 1 - tempX;
                    int temp = matrix[x][y];
                    matrix[x][y] = last;
                    last = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
        };
        Solution solution = new Solution();
        solution.rotate(matrix);
        System.out.println("暂停");
    }
}
