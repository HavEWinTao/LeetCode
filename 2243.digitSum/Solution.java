import java.util.*;

public class Solution {
    public String digitSum(String s, int k) {
        Queue<Character> nums = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            nums.offer(s.charAt(i));
        }
        while (nums.size() > k) {
            int size = nums.size();
            int cnt = 0;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                int num = Integer.parseInt(nums.poll().toString());
                sum += num;
                cnt++;
                if (cnt == k) {
                    offerInt(nums, sum);
                    cnt = 0;
                    sum = 0;
                }
            }
            if (cnt != 0) {
                offerInt(nums, sum);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void offerInt(Queue<Character> nums, int sum) {
        if (sum == 0) {
            nums.add('0');
        }
        Stack<Integer> stack = new Stack<>();
        while (sum != 0) {
            stack.add(sum % 10);
            sum /= 10;
        }
        while (!stack.empty()) {
            int top = stack.pop();
            nums.offer((char) (top + '0'));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "01234567890";
        System.out.println(solution.digitSum(s, 2));
    }
}
