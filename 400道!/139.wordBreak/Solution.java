import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, 0);
    }

    public boolean DFS(String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            return true;
        }
        boolean flag = false;
        for (String word : wordDict) {
            if (index + word.length() <= s.length()) {
                String temp = s.substring(index, index + word.length());
                if (temp.equals(word)) {
                    index += word.length();
                    flag = DFS(s, wordDict, index);
                    if (flag) {
                        return true;
                    }
                    index -= word.length();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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
