public class Solution {
    private String bin;

    public int longestSubsequence(String s, int k) {
        bin = getBin(k);
        int ans = 0;
        int zero = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zero++;
            }
            if (c == '1') {
                int length = getLength(s, k, i);
                ans = Math.max(ans, zero + length);
            }
        }
        return Math.max(ans, zero);
    }

    private int getLength(String s, int k, int index) {
        int n = s.length();
        if (n - index < bin.length()) {
            return n - index;
        }
        int j = 0;
        int ret = 0;
        boolean flag = false;
        for (int i = index; i < n; i++) {
            if (j == bin.length()) {
                break;
            }
            if (flag) {
                ret++;
                j++;
                continue;
            }
            char c = s.charAt(i);
            if (c == bin.charAt(j)) {
                ret++;
                j++;
                continue;
            }
            if (c < bin.charAt(j)) {
                ret++;
                j++;
                flag = true;
            } else {
                i--;
                j++;
            }
        }
        return ret;
    }

    private String getBin(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "1100011000111110110001000011011000";
        int k = 828157402;
        System.out.println(solution.longestSubsequence(s, k));
    }
}
