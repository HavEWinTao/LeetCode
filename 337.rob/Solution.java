import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<TreeNode, Integer[]> dp;

    public int rob(TreeNode root) {
        dp = new HashMap<>();
        DFS(root);
        Integer[] ans = dp.get(root);
        return Math.max(ans[0], ans[1]);
    }

    private void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS(root.left);
        DFS(root.right);
        Integer[] temp = new Integer[2];
        if (root.left == null && root.right == null) {
            temp[0] = 0;
            temp[1] = root.val;
        } else if (root.left == null && root.right != null) {
            Integer[] right = dp.get(root.right);
            temp[0] = Math.max(right[0], right[1]);
            temp[1] = root.val + right[0];
        } else if (root.left != null && root.right == null) {
            Integer[] left = dp.get(root.left);
            temp[0] = Math.max(left[0], left[1]);
            temp[1] = root.val + left[0];
        } else if (root.left != null && root.right != null) {
            Integer[] right = dp.get(root.right);
            Integer[] left = dp.get(root.left);
            temp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            temp[1] = left[0] + right[0] + root.val;
        }
        dp.put(root, temp);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode t11 = new TreeNode(4);
        TreeNode t12 = new TreeNode(5);
        root.left = t11;
        root.right = t12;

        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(3);
        TreeNode t23 = new TreeNode(1);
        t11.left = t21;
        t11.right = t22;
        t12.right = t23;

        System.out.println(solution.rob(root));
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