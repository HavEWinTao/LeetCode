import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //排序
        Arrays.sort(candidates);
        dfs(candidates, target, temp, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<Integer> temp, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        dfs(candidates, target, temp, idx + 1);
        if (target - candidates[idx] >= 0) {
            temp.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], temp, idx);
            temp.remove(temp.size() - 1);
        }
    }
}
