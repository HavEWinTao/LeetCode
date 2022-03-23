public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 != null) {
            if (root2 != null) {
                mergeDFS(root1, root2);
            }
            return root1;
        } else {
            return root2;
        }
    }

    //对左右节点是否为null进行判断即可
    private void mergeDFS(TreeNode root1, TreeNode root2) {
        root1.val = root1.val + root2.val;
        if (root1.left != null) {
            if (root2.left != null) {
                mergeDFS(root1.left, root2.left);
            }
        } else {
            if (root2.left != null) {
                root1.left = root2.left;
            }
        }
        if (root1.right != null) {
            if (root2.right != null) {
                mergeDFS(root1.right, root2.right);
            }
        } else {
            if (root2.right != null) {
                root1.right = root2.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode t111 = new TreeNode(3);
        TreeNode t112 = new TreeNode(2);
        TreeNode t121 = new TreeNode(5);
        root1.left = t111;
        root1.right = t112;
        t111.left = t121;

        TreeNode root2 = new TreeNode(2);
        TreeNode t211 = new TreeNode(1);
        TreeNode t212 = new TreeNode(3);
        TreeNode t221 = new TreeNode(4);
        TreeNode t222 = new TreeNode(7);
        root2.left = t211;
        root2.right = t212;
        t211.right = t221;
        t212.right = t222;

        Solution solution = new Solution();
        solution.mergeTrees(root1, root2);
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