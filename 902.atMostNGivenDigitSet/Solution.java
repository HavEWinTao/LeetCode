public class Solution {
    private String[] digits;

    String maxNum;

    int[] dp;

    int m, n;

    int f(int i, boolean isLimit, boolean isNum) {
        //能够走到最后一位就说明正确的个数+1
        if (i == n) {
            return isNum ? 1 : 0;
        }
        //记忆化搜索
        if (!isLimit && isNum && dp[i] >= 0) {
            return dp[i];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, false, false);
        }
        // 枚举要填入的数字digits[d]
        char up = isLimit ? maxNum.charAt(i) : '9';
        for (String d : digits) {
            if (d.charAt(0) > up) {
                break;
            }
            res += f(i + 1, isLimit && d.charAt(0) == up, true);
        }
        if (!isLimit && isNum) {
            dp[i] = res;
        }
        return res;
    }

    public int atMostNGivenDigitSet(String[] _digits, int max) {
        this.digits = _digits;
        m = digits.length;
        maxNum = String.valueOf(max);
        n = maxNum.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, true, false);
    }
}