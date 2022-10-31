package src;

public class Solution {
    public String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        if (n % 2 == 1) {
            while (n-- > 0) {
                ans.append('a');
            }
        } else {
            while (n-- > 1) {
                ans.append('a');
            }
            ans.append('b');
        }
        return ans.toString();
    }
}
