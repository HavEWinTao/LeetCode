public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        flatten(root.right);
        flatten(root.left);
        TreeNode rightNode = right(root);
        rightNode.right = root.left;
        root.left = null;
    }

    public TreeNode right(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode r11 = new TreeNode(2);
        TreeNode r12 = new TreeNode(5);
        root.left = r11;
        root.right = r12;

        TreeNode r21 = new TreeNode(3);
        TreeNode r22 = new TreeNode(4);
        TreeNode r23 = new TreeNode(6);
        r11.left = r21;
        r11.right = r22;
        r12.right = r23;

        Solution solution = new Solution();
        solution.flatten(root);
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