public class Solution {

    private int mod = (int) (1e9 + 7);

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i + delay; j < i + forget; j++) {
                if (j <= n) {
                    dp[j] = (dp[j] + dp[i]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = n + 1 - forget; i <= n; i++) {
            ans += dp[i];
            ans %= mod;
        }
        return ans % mod;
    }

    //统计第i天新增的人数就好了，然后知道秘密的总人数其实就等于从最后一天往前推forget天的人数和
    //每一个第i天知道秘密的人，都对[i+delay,i+forget)这个区间有贡献，从前往后推即可,时间复杂度O（n^2）

    //溢出问题
    public int peopleAwareOfSecret1(int n, int delay, int forget) {
        int[] A = new int[n + 1];//知道秘密的人数
        int[] B = new int[n + 1];//能传播秘密的人数
        int[] C = new int[n + 1];//第i天新增的人数
        for (int i = 1; i <= delay; i++) {
            A[i] = 1;
        }
        C[1] = 1;
        for (int i = delay + 1; i <= n; i++) {
            if (i == 78) {
                System.out.println("暂停");
            }
            int temp = i - forget >= 1 ? C[i - forget] : 0;
            B[i] = (B[i - 1] + C[i - delay] - temp) % mod;
            C[i] = B[i];
            A[i] = (A[i - 1] + C[i] - temp) % mod;
        }
        if (A[n]<0){
            System.out.println("暂停");
        }
        return A[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int delay = 2;
        int forget = 4;
        for (int i = 5; i <= 1000; i++) {
            int ans1 = solution.peopleAwareOfSecret(i, delay, forget);
            int ans2 = solution.peopleAwareOfSecret1(i, delay, forget);
            if (ans1 != ans2) {
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println(i);
                break;
            }
        }
    }
}
