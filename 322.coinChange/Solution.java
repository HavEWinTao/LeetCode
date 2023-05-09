import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        //int数组变成Integer数组
        //Integer[] temp = Arrays.stream(coins).boxed().toArray(Integer[]::new);
        int max = amount + 1;
        int[] dp = new int[amount + 1];//dp[i]表示拿总额为i的硬币需要多少个硬币
        //我好容易把一维能解决的dp想成二维的
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};

        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, 11));
    }
}
