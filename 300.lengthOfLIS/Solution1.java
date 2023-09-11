public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[ans]) {
                dp[++ans] = nums[i];
                continue;
            }
            int left = 1, right = ans;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[i] < dp[mid]) {
                    right = mid - 1;
                } else if (nums[i] > dp[mid]) {
                    left = mid + 1;
                } else {
                    left = mid;
                    break;
                }
            }
            dp[left] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        {
            int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
            int ans = solution.lengthOfLIS(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{0, 1, 0, 3, 2, 3};
            int ans = solution.lengthOfLIS(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
            int ans = solution.lengthOfLIS(nums);
            System.out.println(ans);
        }
    }
}