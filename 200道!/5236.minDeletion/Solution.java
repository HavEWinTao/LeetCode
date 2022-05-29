import java.util.*;

public class Solution {
    public int minDeletion(int[] nums) {
        int length = nums.length;
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        for (int i = 0; i < temp.size() - 1; ) {
            if (Objects.equals(temp.get(i), temp.get(i + 1))) {
                temp.remove(i + 1);
            } else {
                i = i + 2;
            }
        }
        return temp.size() % 2 == 0 ? length - temp.size() : length - temp.size() + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 5, 6};

        Solution solution = new Solution();
        System.out.println(solution.minDeletion(nums));
    }
}
