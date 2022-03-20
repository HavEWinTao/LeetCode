import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWord {
    class Solution {
        public String longestWord(String[] words) {
            //按字典序排序
            Arrays.sort(words);

            Set<String> dict = new HashSet<>();
            String ans = "";
            for (String word : words) {
                if (word.length() == 1 || dict.contains(word.substring(0, word.length() - 1))) {
                    dict.add(word);
                    if (word.length() > ans.length()) {
                        ans = word;
                    }
                }
            }
            return ans;
        }
    }
}
