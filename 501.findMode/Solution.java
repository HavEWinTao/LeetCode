import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private int pre, cnt, max;
    private List<Integer> ans;

    public int[] findMode(TreeNode root) {
        ans = new ArrayList<>();
        if (root == null) return new int[]{};
        pre = Integer.MIN_VALUE;
        cnt = 0;
        max = 1;
        dfs(root);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (node.val == pre) cnt++;
        else cnt = 1;
        if (cnt > max) {
            max = cnt;
            ans.clear();
            ans.add(node.val);
        } else if (cnt == max) {
            ans.add(node.val);
        }
        pre = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(2);

            int[] ans = solution.findMode(root);
            System.out.println(Arrays.toString(ans));
        }
        {
            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);

            int[] ans = solution.findMode(root);
            System.out.println(Arrays.toString(ans));
        }
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(1);

            int[] ans = solution.findMode(root);
            System.out.println(Arrays.toString(ans));
        }
    }
}