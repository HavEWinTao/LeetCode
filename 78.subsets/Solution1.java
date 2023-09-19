import java.util.*;

public class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums,0,new ArrayList<>(),true);
        return ans;
    }

    public void dfs(int[] nums, int idx, List<Integer> list,boolean flag) {
        if (flag) ans.add(new ArrayList<>(list));
        if (idx==nums.length) return;
        List<Integer> l = new ArrayList<>(list);
        l.add(nums[idx]);
        dfs(nums, idx + 1, list,false);
        dfs(nums, idx + 1, l,true);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            int[] nums = new int[]{1, 2, 3};
            List<List<Integer>> ans = solution.subsets(nums);
            System.out.println(ans);
        }
        {
            int[] nums = new int[]{0};
            List<List<Integer>> ans = solution.subsets(nums);
            System.out.println(ans);
        }
    }
}