public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode l11 = new TreeNode(0);
        TreeNode r11 = new TreeNode(1);
        root.left = l11;
        root.right = r11;
        TreeNode l21 = new TreeNode(0);
        TreeNode l22 = new TreeNode(0);
        l11.left = l21;
        l11.right = l22;
        TreeNode r21 = new TreeNode(0);
        TreeNode r22 = new TreeNode(1);
        r11.left = r21;
        r11.right = r22;
        TreeNode ans = solution.pruneTree(root);
        System.out.println("暂停");
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