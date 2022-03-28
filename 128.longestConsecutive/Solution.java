import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        // key表示num，value表示num最远到达的连续右边界
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int right = map.get(nums[i]);
                while (map.containsKey(right + 1)) {
                    map.remove(right);
                    right = map.get(right + 1);
                }
                map.put(nums[i], right);
                ans = Math.max(ans, right - nums[i] + 1);
            }
        }
        return ans;
    }
}
