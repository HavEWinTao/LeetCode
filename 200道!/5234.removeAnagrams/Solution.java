import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>(Arrays.stream(words).toList());
        for (int i = 1; i < ans.size(); i++) {
            String str1 = ans.get(i - 1);
            String str2 = ans.get(i);
            int[] char1 = new int[26];
            for (int j = 0; j < str1.length(); j++) {
                char1[str1.charAt(j) - 'a']++;
            }
            int[] char2 = new int[26];
            for (int j = 0; j < str2.length(); j++) {
                char2[str2.charAt(j) - 'a']++;
            }
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (char1[j] != char2[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.remove(i);
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"abba", "baba", "bbaa", "cd", "cd"};
        System.out.println(solution.removeAnagrams(words));
    }
}
