public class Solution {
    int n, m, k;

    public int findKthNumber(int _m, int _n, int _k) {
        n = Math.min(_m, _n);
        m = Math.max(_m, _n);
        k = _k;
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = getCnt(mid);//cnt是整个乘法表中小于等于mid的数的个数
            if (cnt >= k) {
                r = mid;//cnt比k大，mid应该再小一些
            } else {
                l = mid + 1;//不然mid应该再大一些
            }
        }
        return r;
    }

    int getCnt(int mid) {
        int a = 0;
        for (int i = 1; i <= n; i++) {//n行
            if (i * m < mid) {//一整行都是小于mid的
                a += m;
            } else {
                a += mid / i;//现在相当于i行m列，mid/i就是该行小于等于mid的个数
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(2, 3, 6));
    }
}
