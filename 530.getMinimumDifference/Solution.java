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

    private int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        dfs(root, -1, Integer.MAX_VALUE);
        return ans;
    }

    private void dfs(TreeNode node, int left, int right) {
        if (node == null) return;
        if (left != -1) {
            ans = Math.min(ans, Math.abs(node.val - left));
        }
        if (right != Integer.MAX_VALUE) {
            ans = Math.min(ans, Math.abs(right - node.val));
        }
        dfs(node.left, left, node.val);

        dfs(node.right, node.val, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            int ans = solution.minDiffInBST(root);
            System.out.println(ans);
        }
        {
            TreeNode root = new TreeNode(90);
            root.left = new TreeNode(69);
            root.left.left = new TreeNode(49);
            root.left.right = new TreeNode(89);
            root.left.left.right = new TreeNode(52);
            int ans = solution.minDiffInBST(root);
            System.out.println(ans);
        }
    }
}