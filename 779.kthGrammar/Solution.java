public class Solution {
    public int kthGrammar(int n, int k) {
        return f(n, k, false);
    }

    public int f(int n, int k, boolean flag) {
        if (n == 1 && k == 1) {
            return flag ? 1 : 0;
        }
        if (n == 2) {
            if (k == 1) {
                return flag ? 1 : 0;
            }
            if (k == 2) {
                return flag ? 0 : 1;
            }
        }
        int num = (int) Math.pow(2, n - 1);
        if (k > num / 2) {
            k = num - k + 1;
            if (n % 2 == 0) {
                flag = !flag;
            }
        }
        return f(n - 1, k, flag);
    }
}