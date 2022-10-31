public class Solution {
    private final int mod = (int) (1e9 + 7);

    public int numPrimeArrangements(int n) {
        int cnt = cntArrange(n);
        long ans = (factorial(cnt) * factorial(n - cnt)) % mod;
        return (int) ans;
    }

    private int cntArrange(int n) {
        int ret = 0;
        loop:
        for (int j = 2; j <= n; j++) {
            for (int i = 2; i * i <= j; i++) {
                if (j % i == 0) {
                    continue loop;
                }
            }
            ret++;
        }
        return ret;
    }

    private long factorial(int num) {
        long ret = 1;
        for (int i = 1; i <= num; i++) {
            ret = (ret * i) % mod;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 100;
        System.out.println(solution.numPrimeArrangements(n));
    }
}
