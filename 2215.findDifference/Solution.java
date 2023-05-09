import java.util.*;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Boolean> answer1 = new HashMap<>();
        Map<Integer, Boolean> answer2 = new HashMap<>();

        Set<Integer> num1 = new HashSet<>();
        Set<Integer> num2 = new HashSet<>();
        for (int num : nums1) {
            num1.add(num);
        }
        for (int num : nums2) {
            num2.add(num);
        }
        for (int num : nums1) {
            if (!num2.contains(num)) {
                answer1.put(num, true);
            }
        }
        for (int num : nums2) {
            if (!num1.contains(num)) {
                answer2.put(num, true);
            }
        }
        ans.add(answer1.keySet().stream().toList());
        ans.add(answer2.keySet().stream().toList());
        return ans;
    }
}
