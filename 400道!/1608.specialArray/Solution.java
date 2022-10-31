import java.util.*;

public class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 0;
        int index = n - 1;
        for (int i = 1000; i >= 0; i--) {
            while (index >= 0 && nums[index] >= i) {
                cnt++;
                index--;
                //System.out.println("" + cnt + " " + i);
            }
            if (cnt == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 5};
        System.out.println(solution.specialArray(nums));
    }
}