public class Solution {
    private StringBuilder sb;

    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        preDfs(root);
        return sb.toString();

    }

    public void preDfs(TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val);

        if (root.left != null || root.right != null) {
            sb.append("(");
        }
        preDfs(root.left);
        if (root.left != null || root.right != null) {
            sb.append(")");
        }

        if (root.right != null) {
            sb.append("(");
        }
        preDfs(root.right);
        if (root.right != null) {
            sb.append(")");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        System.out.println(solution.tree2str(n1));
    }
}