import java.util.*;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return quickFind(nums, nums.length - k, 0, nums.length - 1);
    }

    public int quickFind(int[] nums, int k, int left, int right) {
        int idx = new Random().nextInt(right - left + 1) + left;
        int pivot = partition(nums, idx, left, right);
        if (pivot == k) {
            return nums[k];
        }
        if (pivot < k) {
            while (pivot + 2 < right && pivot + 1 < k && nums[pivot + 1] == nums[pivot]) pivot++;
            return quickFind(nums, k, pivot + 1, right);
        }
        return quickFind(nums, k, left, pivot - 1);
    }

    public int partition(int[] nums, int idx, int left, int right) {
        swap(nums, idx, right);
        int i = left;
        for (int j = i; j < right; j++) {
            if (nums[j] < nums[right]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int[] nums = new int[]{3, 2, 1, 5, 6, 4};
            int ans = solution.findKthLargest(nums, 2);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{99, 99};
            int ans = solution.findKthLargest(nums, 1);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{1, 2, 3, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -5, -4, -3, -2, -1};
            int ans = solution.findKthLargest(nums, 50);
            System.out.println(ans);
        }
    }
}