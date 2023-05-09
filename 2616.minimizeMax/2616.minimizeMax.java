import java.util.*;

public class minimizeMax {
    public int minimizeMax(int[] nums, int p) {
        int left = 0, right = 1000000000;
        Arrays.sort(nums);
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] <= mid) {
                    count++;
                    i++;
                }
            }
            if (count < p) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        minimizeMax solution = new minimizeMax();
        int[] nums = new int[]{8, 9, 1, 5, 4, 3, 6, 4, 3, 7};
        int p = 4;
        System.out.println(solution.minimizeMax(nums, p));
    }
}
