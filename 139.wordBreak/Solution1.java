import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        //dp[i]表示字符串s前i个字符是否能被空格拆分成若干个字典中出现的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //substring(i,j),[i,j)包左不包右
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add(new String("cats"));
        wordDict.add(new String("dog"));
        wordDict.add(new String("sand"));
        wordDict.add(new String("and"));
        wordDict.add(new String("cat"));
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
