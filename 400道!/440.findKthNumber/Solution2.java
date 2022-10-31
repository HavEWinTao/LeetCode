public class Solution2 {
    public int findKthNumber(int n, int k) {
        int ans = 1;
        while (k > 1) {
            int count = count(ans, ans + 1, n);
            if (count < k) {
                ans++;
                k -= count;
            } else {
                ans *= 10;
                k--;
            }
        }
        return ans;
    }

    public int count(long lower, long upper, long n) {
        int num = 0;
        while (lower <= n) {
            num += Math.min(n + 1, upper) - lower;
            lower *= 10;
            upper *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int ans = solution2.findKthNumber(681692778, 351251360);
        System.out.println(ans);
    }
}
