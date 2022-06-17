import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (find(nums, i + 1, k + nums[i])) {
                ans++;
            }
            while (i < n - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return ans;
    }

    private boolean find(int[] nums, int left, int target) {
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return nums[left] == target;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int k = 0;
        System.out.println(solution.findPairs(nums, k));
    }
}
