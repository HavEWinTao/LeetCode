import java.util.*;

public class Solution {

    Map<Integer, Set<Integer>> index;
    Random r;

    public Solution(int[] nums) {
        r = new Random();
        index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> temp = index.getOrDefault(nums[i], new HashSet<>());
            temp.add(i);
            index.put(nums[i], temp);
        }
    }

    public int pick(int target) {
        Set<Integer> temp = index.get(target);
        int randomIndex = r.nextInt(temp.size());
        int index = 0;
        int ans = 0;
        for (int num : temp) {
            if (index == randomIndex) {
                ans = num;
                break;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);
        while (true) {
            System.out.println(solution.pick(1));
        }
    }
}
