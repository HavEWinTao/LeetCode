import java.util.*;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        String[] ops = new String[]{"Push", "Pop"};
        int m = target.length;
        int index1 = 1;
        int index2 = 0;
        while (index1 <= n && index2 < m) {
            ans.add(ops[0]);
            if (index1 < target[index2]) {
                ans.add(ops[1]);
            } else if (index1 == target[index2]) {
                index2++;
            }
            index1++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] target = new int[]{1, 2};
        System.out.println(solution.buildArray(target, 4));
    }
}