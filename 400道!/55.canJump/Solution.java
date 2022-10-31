public class Solution {
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return true;
            }
            if (nums[i] == 0) {
                return false;
            }
            int max = Integer.MIN_VALUE;
            int index = 1;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    if (i + j == nums.length - 1) {
                        return true;
                    }
                    if (i + j + nums[i + j] >= max) {
                        max = i + j + nums[i + j];
                        index = j;
                    }
                } else {
                    return true;
                }
            }
            i = i + index - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //这个例子很好的说明了贪心max=i+j+nums[i+j]
        //max应该指当前所能到达的最远的值，而不是当前所能跳的这些格子的最大值
        //max=num[i+j]只考虑到往i+j跳之后还能再跳多少，没用考虑到跳到i+j已经跳了多少
        int[] nums = new int[]{4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0};
        System.out.println(solution.canJump(nums));
    }
}
