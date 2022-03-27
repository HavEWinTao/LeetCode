public class Solution {
    public boolean isValidBST(TreeNode root) {
        return DFS(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean DFS(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return DFS(root.left, lower, root.val) && DFS(root.right, root.val, upper);
    }
}

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