import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt + 1);
        }
        int[] ret = new int[2];
        map.values().forEach((value) -> {
            ret[0] += value / 2;
            ret[1] += value % 2;
        });
        return ret;
    }
}
