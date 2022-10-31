import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1 && nums[nums[i] - 1] == nums[i]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution.findDuplicates(nums));
    }
}
