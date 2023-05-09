public class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
                while (i < n && s.charAt(i) == '1') {
                    i++;
                }
                i--;
            }
        }
        return cnt == 1;
    }
}