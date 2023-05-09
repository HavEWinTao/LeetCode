import java.util.*;

public class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums[0].length; i++) {
            set.add(nums[0][i]);
        }
        Set<Integer> ansSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int size = nums[i].length;
            for (int j = 0; j < size; j++) {
                if (set.contains(nums[i][j])) {
                    ansSet.add(nums[i][j]);
                }
            }
            set = new HashSet<>(ansSet);
            ansSet.clear();
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
