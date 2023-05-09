import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String str : words) {
            if (match(str, pattern)) {
                ans.add(str);
            }
        }
        return ans;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> biJection1 = new HashMap<>();
        Map<Character, Character> biJection2 = new HashMap<>();
        if (word.length() != pattern.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (w != p) {
                biJection1.putIfAbsent(word.charAt(i), p);
                biJection2.putIfAbsent(pattern.charAt(i), w);
                Character flag1 = biJection1.get(w);
                Character flag2 = biJection2.get(p);
                if ((!(flag1 == p)) || (!(flag2 == w))) {
                    return false;
                }
            } else {
                biJection1.put(word.charAt(i), pattern.charAt(i));
                biJection2.put(pattern.charAt(i), word.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(solution.findAndReplacePattern(words, pattern));
    }
}
