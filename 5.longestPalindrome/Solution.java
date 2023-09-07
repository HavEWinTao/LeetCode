public class Solution{

    public String longestPalindrome(String _s) {
        if (_s == null || _s.isEmpty()) {
            return "";
        }
        char[] s = _s.toCharArray();
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length; i++) {
            int len1 = fn(s, i, i);
            int len2 = fn(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return String.copyValueOf(s, left, right - left + 1);
    }

    private int fn(char[] s, int left, int right) {
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            String s = "babad";
            String ans = solution.longestPalindrome(s);
            System.out.println(ans);
        }
    }
}