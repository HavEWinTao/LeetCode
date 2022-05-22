import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    private Map<Character, Integer> index;

    public boolean isAlienSorted(String[] words, String order) {
        index = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            index.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!stringCmp(words[i], words[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private boolean stringCmp(String a, String b) {
        int i = 0;
        do {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (index.get(c1) < index.get(c2)) {
                return true;
            } else if (Objects.equals(index.get(c1), index.get(c2))) {
                i++;
            } else {
                return false;
            }
        } while (i < a.length() && i < b.length());
        return a.length() <= b.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(solution.isAlienSorted(words, order));
    }
}
