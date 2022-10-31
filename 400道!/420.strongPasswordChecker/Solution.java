public class Solution {
    public int strongPasswordChecker(String password) {
        char[] cs = password.toCharArray();
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (char c : cs) {
            if (c >= 'a' && c <= 'z') {
                hasLower = 1;
            } else if (c >= '0' && c <= '9') {
                hasDigit = 1;
            } else if (c >= 'A' && c <= 'Z') {
                hasUpper = 1;
            }
        }
        int m = hasLower + hasUpper + hasDigit;
        if (n < 6) {//仅使用增加
            return Math.max(6 - n, 3 - m);
        } else if (n <= 20) {//仅使用替换
            int replace = 0;
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && cs[j] == cs[i]) {
                    j++;
                }
                int cnt = j - i;
                if (cnt >= 3) {
                    replace = replace + cnt / 3;
                }
                i = j;
            }
            return Math.max(replace, 3 - m);
        } else {
            int replace = 0;//长度为n时满足3个字母不连续条件的替换次数
            int[] cnts = new int[3];
            //cnts[i]=x含义为：在所有连续段长度不低于3的连续段中，长度余数为i的数量有x个
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && cs[j] == cs[i]) {
                    j++;
                }
                int cnt = j - i;
                if (cnt >= 3) {
                    replace = replace + cnt / 3;
                    cnts[cnt % 3]++;
                }
                i = j;
            }
            int base = n - 20, cur = base;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    cnts[i] = replace;
                }
                if (cnts[i] != 0 && cur > 0) {
                    int t = Math.min(cnts[i] * (i + 1), cur);
                    cur -= t;
                    replace -= t / (i + 1);
                }
            }
            return base + Math.max(replace, 3 - m);
        }
    }
}
