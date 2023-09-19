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

    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if (root==null) return ans;
        dfs(root, targetSum, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode node, int target, List<Integer> list) {
        target -= node.val;
        List<Integer> l = new ArrayList<>(list);
        l.add(node.val);
        if (node.left == null && node.right == null) {
            if (target == 0) ans.add(l);
            return;
        }
        if (node.left != null) dfs(node.left, target, l);
        if (node.right != null) dfs(node.right, target, l);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);
            root.right.right.left = new TreeNode(5);
            root.right.right.right = new TreeNode(1);
            List<List<Integer>> ans = solution.pathSum(root, 22);
            System.out.println(ans);
        }
    }
}