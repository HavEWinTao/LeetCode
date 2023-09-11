import java.util.*;

public class Solution {

    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++) {
                temp[(num + j) % 3] = Math.max(dp[(num + j) % 3], num + dp[j]);
            }
            dp = temp;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int[] nums = new int[]{3, 6, 5, 1, 8};
            int ans = solution.maxSumDivThree(nums);
            System.out.println(ans);
        }
    }
}