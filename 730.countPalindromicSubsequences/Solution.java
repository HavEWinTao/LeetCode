public class Solution {
    int MOD = (int) 1e9 + 7;

    public int countPalindromicSubsequences(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        //定义f[i][j]为考虑字符串s中的[i,j]范围内回文子序列的个数
        //最终答案为f[0][n-1]
        int[][] f = new int[n][n];
        int[] L = new int[4], R = new int[4];
        Arrays.fill(L, -1);
        for (int i = n - 1; i >= 0; i--) {
            L[cs[i] - 'a'] = i;
            Arrays.fill(R, -1);
            for (int j = i; j < n; j++) {
                R[cs[j] - 'a'] = j;
                for (int k = 0; k < 4; k++) {
                    if (L[k] == -1 || R[k] == -1) continue;
                    int l = L[k], r = R[k];
                    if (l == r) f[i][j] = (f[i][j] + 1) % MOD;
                    else if (l == r - 1) f[i][j] = (f[i][j] + 2) % MOD;
                    else f[i][j] = (f[i][j] + f[l + 1][r - 1] + 2) % MOD;
                }
            }
        }
        return f[0][n - 1];
    }
}
