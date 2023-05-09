import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = findBound(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int indexleft = index;
        while (indexleft >= 0 && nums[indexleft] == target) {
            indexleft--;
        }
        int indexRight = index;
        while (indexRight < nums.length && nums[indexRight] == target) {
            indexRight++;
        }
        return new int[]{indexleft + 1, indexRight - 1};
    }

    public int findBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = new int[]{1};
        System.out.println(Arrays.toString(solution.searchRange(nums, 1)));
    }
}
