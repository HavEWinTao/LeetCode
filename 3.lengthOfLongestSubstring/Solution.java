public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] visit = new boolean[128];
        char[] str = s.toCharArray();
        int n = str.length;
        int ans = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (visit[str[j]]) {
                visit[str[i]] = false;
                i++;
            } else {
                visit[str[j]] = true;
                j++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}