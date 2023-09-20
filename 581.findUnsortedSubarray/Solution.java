import java.util.*;

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.peek());
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        int right = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.peek());
                stack.pop();
            }
            stack.add(i);
        }
        if (left == nums.length - 1 && right == 0) {
            return 0;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
            int ans = solution.findUnsortedSubarray(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{1, 3, 2, 2, 2};
            int ans = solution.findUnsortedSubarray(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{1, 2, 3, 3, 3};
            int ans = solution.findUnsortedSubarray(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{2, 3, 3, 2, 4};
            int ans = solution.findUnsortedSubarray(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{1, 3, 5, 4, 2};
            int ans = solution.findUnsortedSubarray(nums);
            System.out.println(ans);
        }
    }
}