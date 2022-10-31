public class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        int length = s.length();
        for (String word : words) {
            int len = word.length();
            if (len > length) {
                continue;
            }
            if (s.substring(0, len).equals(word)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"a", "ab", "c", "ab", "bc", "abc"};
        System.out.println(solution.countPrefixes(words, "abc"));
    }
}
