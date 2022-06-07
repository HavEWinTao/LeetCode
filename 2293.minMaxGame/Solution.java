import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        int[] ans = Arrays.copyOf(nums, n);
        while (n != 1) {
            n = n / 2;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    ans[i] = Math.min(ans[2 * i], ans[2 * i + 1]);
                } else {
                    ans[i] = Math.max(ans[2 * i], ans[2 * i + 1]);
                }
            }
        }
        return ans[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{70, 38, 21, 22};
        System.out.println(solution.minMaxGame(nums));
    }
}
