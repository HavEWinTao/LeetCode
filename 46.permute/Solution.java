import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ans;
    private int len;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //数组变List
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        DFS(numList, 0, temp);
        return ans;
    }

    public void DFS(List<Integer> list, int length, List<Integer> temp) {
        if (length == len) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.remove(i);
            temp.add(num1);
            DFS(list, length + 1, temp);
            int num2 = temp.remove(length);
            list.add(i, num2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> ans = solution.permute(nums);
        System.out.println(ans);
    }
}
