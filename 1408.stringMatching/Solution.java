import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].matches("(.*)" + words[i] + "(.*)")) {
                    ans.add(words[i]);
                    continue loop;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"mass", "as", "hero", "superhero"};
        System.out.println(solution.stringMatching(words));
    }
}