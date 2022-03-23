public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        TreeNode r11 = new TreeNode(2);
        TreeNode r12 = new TreeNode(7);
        root.left = r11;
        root.right = r12;

        TreeNode r21 = new TreeNode(1);
        TreeNode r22 = new TreeNode(3);
        TreeNode r23 = new TreeNode(6);
        TreeNode r24 = new TreeNode(9);
        r11.left = r21;
        r11.right = r22;
        r12.left = r23;
        r12.right = r24;

        Solution solution = new Solution();
        root = solution.invertTree(root);
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