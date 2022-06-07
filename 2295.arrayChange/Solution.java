import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);//值->下标
        }
        for (int[] operation : operations) {
            int j = index.get(operation[0]);
            index.remove(operation[0]);
            nums[j] = operation[1];
            index.put(operation[1], j);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 4, 6};
        int[][] operations = new int[][]{{1, 3}, {4, 7}, {6, 1}};
        System.out.println(Arrays.toString(solution.arrayChange(nums, operations)));
    }
}
