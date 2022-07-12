public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] row = new int[m];
        int[] col = new int[n];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int ans = 0;
        for (int i : row) {
            for (int j : col) {
                if ((i + j) % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
