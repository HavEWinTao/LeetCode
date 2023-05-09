import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int ans = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && chs[left] != chs[i]) {
                left--;
            }
            while (right < n && chs[right] != chs[i]) {
                right++;
            }
            ans += (i - left) * (right - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "LEETCODE";
        System.out.println(solution.uniqueLetterString(s));
    }
}