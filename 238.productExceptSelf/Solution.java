import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = nums[0];
        R[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i];
        }
        int[] ans = new int[n];
        ans[0] = R[1];
        ans[n - 1] = L[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = L[i - 1] * R[i + 1];

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }
}
