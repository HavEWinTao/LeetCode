public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] show = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            show[allowed.charAt(i) - 'a'] = true;
        }
        int ans = 0;
        loop:
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!show[word.charAt(i) - 'a']) {
                    continue loop;
                }
            }
            ans++;
        }
        return ans;
    }
}