import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int length = s.length();
        int n = words.length;
        int m = words[0].length();
        int left = 0;
        List<Integer> ans = new ArrayList<>();
        while (left <= (length - n * m)) {
            List<String> list = new ArrayList<>(List.of(words));
            int index = left;
            loop:
            for (int i = 0; i < n; i++) {
                String str = s.substring(index, index + m);
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(str)) {
                        list.remove(j);
                        index += m;
                        continue loop;
                    }
                }
                break;
            }
            if (list.isEmpty()) {
                ans.add(left);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word", "good", "best", "good"};
        System.out.println(solution.findSubstring(s, words));
    }
}
