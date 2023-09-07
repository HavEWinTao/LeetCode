public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[right] > nums[left]) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    if (nums[mid] < nums[right]) {
                        if (target <= nums[right]) left = mid + 1;
                        else right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < nums[right]) {
                        right = mid - 1;
                    } else {
                        if (target < nums[left]) left = mid + 1;
                        else right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
            int target = 0;
            int ans = solution.search(nums, target);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
            int target = 3;
            int ans = solution.search(nums, target);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{1};
            int target = 2;
            int ans = solution.search(nums, target);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{3, 5, 1};
            int target = 3;
            int ans = solution.search(nums, target);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
            int target = 8;
            int ans = solution.search(nums, target);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{5,1,3};
            int target = 3;
            int ans = solution.search(nums, target);
            System.out.println(ans);
        }
    }
}