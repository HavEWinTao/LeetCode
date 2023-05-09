import java.util.HashMap;
import java.util.Map;

public class checkSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum % k)) {
                if (i - map.get(sum % k) > 1) return true;
            } else map.put(sum % k, i);
        }
        return false;
    }

    public static void main(String[] args) {
        checkSubarraySum solution = new checkSubarraySum();
        int[] nums = new int[]{23, 2, 4, 6, 6};
        int k = 7;
        System.out.println(solution.checkSubarraySum(nums, k));
    }
}
