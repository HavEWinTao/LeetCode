import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        String[] _wordDict = new String[]{"leet", "code"};
        List<String> wordDict = Arrays.stream(_wordDict).toList();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}