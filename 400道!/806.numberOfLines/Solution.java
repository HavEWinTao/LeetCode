public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int ans = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index + widths[c - 'a'] <= 100) {
                index += widths[c - 'a'];
            } else {
                ans++;
                index = widths[c - 'a'];
            }
        }
        return new int[]{ans, index};
    }
}
