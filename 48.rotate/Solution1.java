class Solution {
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
}
