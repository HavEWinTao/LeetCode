import java.util.*;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        List<String> words = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isAlphabetic(c)) {
                temp.append(c);
            } else {
                if (!temp.isEmpty()) {
                    words.add(temp.toString());
                }
                temp = new StringBuilder();
            }
        }
        if (!temp.isEmpty()) {
            words.add(temp.toString());
        }

        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> num = new HashMap<>();
        String ans = null;
        int maxNum = 0;
        for (String word : words) {
            if (!set.contains(word)) {
                int nowNum = num.getOrDefault(word, 0);
                num.put(word, nowNum + 1);
                if (nowNum + 1 > maxNum) {
                    ans = word;
                    maxNum = nowNum + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String[] banned = new String[]{"hit"};
        //String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = new String[]{"a"};
        System.out.println(solution.mostCommonWord(paragraph, banned));
    }
}
