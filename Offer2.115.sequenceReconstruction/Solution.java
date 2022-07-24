import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int n = nums.length;
        for (int[] sequence : sequences) {
            int length = sequence.length;
            int parent = sequence[0];
            for (int i = 1; i < length; i++) {
                int value = sequence[i];
                List<Integer> list = tree.getOrDefault(parent, new ArrayList<>());
                list.add(value);
                tree.put(parent, list);
                parent = value;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int s = nums[i];
            int t = nums[i + 1];
            if (tree.get(s) != null) {
                if (tree.get(s).contains(t)) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        int[][] sequences = new int[][]{{1, 2}, {1, 3}, {2, 3}};
    }
}
