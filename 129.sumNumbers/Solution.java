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

    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left == null && node.right == null) ans += Integer.parseInt(sb.toString());
        if (node.left != null) dfs(node.left, sb);
        if (node.right != null) dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int ans = solution.sumNumbers(root);
        System.out.println(ans);
    }
}