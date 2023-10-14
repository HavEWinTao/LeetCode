public class Solution {
    private int[][] cache;

    public int uniquePaths(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        m--;
        n--;
        int c = m + n;
        cache = new int[c + 1][n + 1];
        return fn(c, n);
    }

    public int fn(int m, int n) {
        if (n == 0 || m == n) return 1;
        if (cache[m][n] != 0) return cache[m][n];
        int ret = fn(m - 1, n - 1) + fn(m - 1, n);
        cache[m][n] = ret;
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(10, 10));
    }
}