import java.util.Arrays;

public class canPartition {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int sum = 0, maxV = 0;
        for (int num : nums) {
            sum += num;
            maxV = Math.max(maxV, num);
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        if (maxV > target) return false;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1};
        canPartition solution = new canPartition();
        System.out.println(solution.canPartition(nums));
    }
}
