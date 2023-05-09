public class Solution {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        Set<Character> set = new HashSet<>();
        char[] o = new char[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            o[i] = c;
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                sb.append(c);
                continue;
            }
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            char c = o[i];
            if (c == 0) {
                break;
            }
            for (int j = 0; j < cnt[c - 'a']; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}