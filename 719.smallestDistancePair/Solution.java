import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //数对由nums[i]和nums[j]组成且满足0<=i<j<nums.length
    //符合要求，因为是取abs，排序后也能保证数对都相同
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            int cnt = binarySearch(nums, mid);
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int binarySearch(int[] nums, int target) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1, right = nums.length;
            while (left < right) {
                int mid = (left + right) / 2;
                int abs = Math.abs(nums[mid] - nums[i]);
                if (abs <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            cnt += left - i - 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{62, 100, 4};
        int k = 2;
        System.out.println(solution.smallestDistancePair(nums, k));
    }
}
