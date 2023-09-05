import java.util.*;

public class Main {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int idx = new Random().nextInt(right - left + 1) + left;
            int pivot = partition(nums, left, right, idx);
            int leftPivot = pivot - 1;
            int rightPivot = pivot + 1;
            //优化重复元素
            while (leftPivot > left && nums[leftPivot] == nums[pivot]) {
                leftPivot--;
            }
            while (rightPivot < right && nums[rightPivot] == nums[pivot]) {
                rightPivot++;
            }
            quickSort(nums, left, leftPivot);
            quickSort(nums, rightPivot, right);
        }
    }

    public int partition(int[] nums, int left, int right, int idx) {
        swap(nums, idx, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= nums[right]) {
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
        Main solution = new Main();
        {
            int[] nums = new int[]{5, 2, 3, 1};
            solution.sortArray(nums);
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = new int[]{5, 1, 1, 2, 0, 0};
            solution.sortArray(nums);
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = new int[20000];
            Arrays.fill(nums, 2);
            solution.sortArray(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}