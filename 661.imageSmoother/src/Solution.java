public class Solution {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                int cnt = 0;
                for (int x = -1; x <= 1; x++) {
                    if ((i + x >= 0) && (i + x < row)) {
                        for (int y = -1; y <= 1; y++) {
                            if ((j + y >= 0) && (j + y < col)) {
                                sum += img[i + x][j + y];
                                cnt++;
                            }
                        }
                    }
                }
                ans[i][j] = sum / cnt;
            }
        }
        return ans;
    }

    //另一种解法，前缀和
    //sum[i][j]表示和整片区域的和，然后求sum矩阵后再ij循环一次
}
