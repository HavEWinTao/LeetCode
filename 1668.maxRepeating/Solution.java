public class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }
        int[] dp = new int[n];
        for (int i = m - 1; i < n; ++i) {
            boolean valid = true;
            //判断以i结尾的前面的若干字符是否是word
            for (int j = 0; j < m; ++j) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                //如果以i结尾的前i个字符是word，就直接更新dp[i]
                dp[i] = (i == m - 1 ? 0 : dp[i - m]) + 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}