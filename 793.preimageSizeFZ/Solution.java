public class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    public long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (zeta(mid) < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public long zeta(long x) {//阶乘中0的个数
        long ret = 0;
        while (x != 0) {
            ret += x / 5;
            x /= 5;
        }
        return ret;
    }
}
