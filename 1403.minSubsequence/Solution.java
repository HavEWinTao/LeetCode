import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> ans = new ArrayList<>();
        int index = nums.length - 1;
        int temp = 0;
        while (temp <= sum) {
            temp += nums[index];
            sum -= nums[index];
            ans.add(nums[index]);
            index--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 3, 10, 9, 8};
        System.out.println(solution.minSubsequence(nums));
    }
}