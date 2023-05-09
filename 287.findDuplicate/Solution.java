import java.util.Arrays;

public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //设长度为m+c，c是环的长度
        int pre1 = 0;//已经在环内走了n-m步，再走m步就到环的开始了
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};

        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }
}
