import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = list.length - 1; i > 0 && ans.size() < k; i--) {
            if (list[i] != null) {
                ans.addAll(list[i]);
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
