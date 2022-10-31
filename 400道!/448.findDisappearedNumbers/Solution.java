import java.util.ArrayList;
import java.util.List;

public class Solution {
    //nums本身充当hash,然后+n通过%n取原数
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i] - 1) % nums.length] += nums.length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums = new int[]{2, 2};
        System.out.println(solution.findDisappearedNumbers(nums));
    }
}
