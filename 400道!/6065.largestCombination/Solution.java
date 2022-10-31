import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public int largestCombination(int[] candidates) {
        List<List<Integer>> number = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            number.add(new ArrayList<>());
        }
        boolean[] flag = new boolean[31];
        for (int i = 0; i < 31; i++) {
            for (int num : candidates) {
                if (((num >> i) & 1) == 1) {
                    number.get(i).add(num);
                }
                if (num > 0) {
                    flag[i] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (flag[i]) {
                ans = Math.max(ans, number.get(i).size());
            }
        }
        return ans;
    }
}
