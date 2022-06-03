import java.util.*;

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return DFS(root, 0);
    }

    private int DFS(TreeNode root, int base) {
        base = base * 2 + root.val;
        if (root.left == null && root.right != null) {
            return DFS(root.right, base);
        }
        if (root.left != null && root.right == null) {
            return DFS(root.left, base);
        }
        if (root.left == null && root.right == null) {
            return base;
        }
        return DFS(root.left, base) + DFS(root.right, base);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode l11 = new TreeNode(1);
        TreeNode r11 = new TreeNode(1);
        root.left = l11;
        //root.right = r11;
        TreeNode l21 = new TreeNode(0);
        TreeNode l22 = new TreeNode(1);
        //l11.left = l21;
        //l11.right = l22;
        TreeNode r21 = new TreeNode(0);
        TreeNode r22 = new TreeNode(1);
        r11.left = r21;
        r11.right = r22;
        System.out.println(solution.sumRootToLeaf(root));
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