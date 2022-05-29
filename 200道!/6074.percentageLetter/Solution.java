public class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == letter) {
                cnt++;
            }
        }
        return cnt * 100 / n;
    }
}
