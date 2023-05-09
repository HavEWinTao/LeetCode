import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int arrayNesting(int[] nums) {
        int ans = 1;
        int n = nums.length;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            int num = nums[i];
            while (!set.contains(num)) {
                set.add(num);
                visit[num] = true;
                num = nums[num];
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
