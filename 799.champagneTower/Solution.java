public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] ans = new double[query_row + 2][query_glass + 1];
        ans[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            boolean flag = false;
            for (int j = 0; j <= i && j <= query_glass; j++) {
                double size = ans[i][j];
                if (size > 1) {
                    size--;
                    ans[i][j] = 1;
                    ans[i + 1][j] += size / 2;
                    if (j + 1 <= query_glass) {
                        ans[i + 1][j + 1] += size / 2;
                    }
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return ans[query_row][query_glass];
    }
}