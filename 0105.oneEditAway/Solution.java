public class Solution {
    public boolean oneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) == 1) {
            boolean flag = false;
            int len = Math.max(len1, len2);
            String str1 = len == len1 ? first : second;//str1是长的那个
            String str2 = len == len1 ? second : first;
            for (int i = 0; i < len; i++) {
                if ((str1.substring(0, i) + str1.substring(i + 1)).equals(str2)) {
                    flag = true;
                    break;
                }
            }
            return flag;
        } else if (len1 == len2) {
            int cnt = 0;
            int index = 0;
            while (index < len1 && cnt < 2) {
                if (first.charAt(index) != second.charAt(index)) {
                    cnt++;
                }
                index++;
            }
            return cnt < 2;
        } else {
            return false;
        }
    }

    public boolean oneEditAway2(String a, String b) {
        int n = a.length(), m = b.length();
        if (Math.abs(n - m) > 1) return false;
        if (n > m) return oneEditAway(b, a);
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            char c1 = a.charAt(i), c2 = b.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
            } else {
                if (n == m) {
                    i++;
                    j++;
                    cnt++;
                } else {
                    j++;
                    cnt++;
                }
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.oneEditAway("", "a"));
    }
}
