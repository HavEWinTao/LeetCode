import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String toGoatLatin(String sentence) {
        String vowel = "aeiouAEIOU";
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = word.charAt(0);
            if (vowel.contains(String.valueOf(c))) {
                sb.append(word).append("ma");
            } else {
                sb.append(word.substring(1)).append(c).append("ma");
            }
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String sentence = "I speak Goat Latin";
        System.out.println(solution.toGoatLatin(sentence));
    }
}
