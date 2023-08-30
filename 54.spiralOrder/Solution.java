class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            for (; j < n - count; k++) ans.add(matrix[i][j]);
            j--;
            i++;
            if (i >= m - count) break;
            for (; i < m - count; i++) ans.add(matrix[i][j]);
            j--;
            i--;
            if (j < count) break;
            for (; j >= count; j--) ans.add(matrix[i][j]);
            j++;
            i--;
            if (i <= count) break;
            for (; i > count; i--) ans.add(matrix[i][j]);
            i++;
            j++;
            if (j >= n - count) break;
            count++;
        }
        return ans;
    }
}