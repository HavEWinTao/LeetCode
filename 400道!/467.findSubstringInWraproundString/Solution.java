import java.util.Arrays;

public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int n = p.length();
        dp[p.charAt(0) - 'a'] = 1;
        int k = 1;//k是用来标记当前字符串长度的
        for (int i = 1; i < n; i++) {
            int index1 = p.charAt(i) - 'a';
            int index2 = (p.charAt(i - 1) - 'a' + 1) % 26;
            if (index1 == index2) {
                k++;
            } else {
                k = 1;
            }
            dp[index1] = Math.max(k, dp[index1]);
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstringInWraproundString("zaba"));
    }
}
