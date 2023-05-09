import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char index = 'a';
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ') {
                if (!map.containsKey(c)) {
                    map.put(c, index++);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            ans.append(map.getOrDefault(c, ' '));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeMessage("the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"));
    }
}
