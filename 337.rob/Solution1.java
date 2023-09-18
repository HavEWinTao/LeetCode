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

    Map<TreeNode, Integer[]> mp;

    public int rob(TreeNode root) {
        mp = new HashMap<>();
        dfs(root);
        return Math.max(mp.get(root)[0], mp.get(root)[1]);
    }

    private void dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            mp.put(node, new Integer[]{0, node.val});
            return;
        }
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
        Integer[] dp = new Integer[2];
        dp[0] = (node.left == null ? 0 : Math.max(mp.get(node.left)[0], mp.get(node.left)[1]))
                + (node.right == null ? 0 : Math.max(mp.get(node.right)[0], mp.get(node.right)[1]));
        dp[1] = node.val + (node.left == null ? 0 : mp.get(node.left)[0]) + (node.right == null ? 0 : mp.get(node.right)[0]);
        mp.put(node, dp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(1);
            int ans = solution.rob(root);
            System.out.println(ans);
        }
        {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(1);
            root.left.left = new TreeNode(2);
            root.left.left.left = new TreeNode(3);
            int ans = solution.rob(root);
            System.out.println(ans);
        }
    }
}