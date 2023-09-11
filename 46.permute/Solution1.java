import java.util.*;

public class Solution1 {

    private List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums,new boolean[nums.length],new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums,boolean[] vis,List<Integer> temp){
        if (temp.size()== nums.length) ans.add(new ArrayList<>(temp));
        for (int i=0;i<nums.length;i++){
            if (vis[i]) continue;
            vis[i] = true;
            temp.add(nums[i]);
            dfs(nums,vis,temp);
            temp.remove(temp.size()-1);
            vis[i] = false;
        }
    }
}