import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        //long startTime = new Date().getTime();
        DFS(0, nums, temp);
        //long endTime = new Date().getTime();

        //System.out.println("本递归运行 " + (endTime - startTime) + " 毫秒完成。");

        return ans;
    }

    public void DFS(int length, int[] nums, List<Integer> temp) {
        if (length == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[length]);
        DFS(length + 1, nums, temp);
        temp.remove(temp.size() - 1);
        DFS(length + 1, nums, temp);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 0};

        Solution solution = new Solution();

        List<List<Integer>> ans = solution.subsets(nums);
        System.out.println(ans);
    }
}
