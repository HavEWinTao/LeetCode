import java.util.*;

public class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = calSum(num);
            List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
            list.add(num);
            map.put(sum, list);
        }
        int ans = -1;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            int size = list.size();
            if (size >= 2) {
                Collections.sort(list);
                int temp = list.get(size - 1) + list.get(size - 2);
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    private int calSum(int num) {
        int ret = 0;
        while (num != 0) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }
}
