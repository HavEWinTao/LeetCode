public class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = -1;
        int ans = Integer.MIN_VALUE;
        int cnt = 0;
        int temp = 1;
        int mul = -1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ans = Math.max(ans, 0);
                cnt = 0;
                left = -1;
                temp = 1;
                flag = false;
                continue;
            }
            if (left == -1) left = i;
            temp *= nums[i];
            if (nums[i] < 0) cnt = (cnt + 1) % 2;
            if (cnt == 0) ans = Math.max(ans, temp);
            else {
                if (!flag) {
                    flag = true;
                    mul = temp;
                    continue;
                }
                ans = Math.max(ans, temp / mul);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            int[] nums = new int[]{2, 3, -2, 4};
            int ans = solution.maxProduct(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{-2, 0, -1};
            int ans = solution.maxProduct(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{0, 2};
            int ans = solution.maxProduct(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{3, -1, 4};
            int ans = solution.maxProduct(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{-5, 0, 2};
            int ans = solution.maxProduct(nums);
            System.out.println(ans);
        }
    }
}