import java.util.*;

class Solution {

    private Set<String> serialize;

    private Map<String, TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize = new HashSet<>();
        ans = new HashMap<>();
        DFS(root);
        return ans.values().stream().toList();
    }

    private String DFS(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = DFS(root.left);
        String right = DFS(root.right);
        left = left.equals("") ? "" : "(" + left + ")";
        right = right.equals("") ? "" : "(" + right + ")";
        String ser = left + root.val + right;
        if (serialize.contains(ser)) {
            ans.put(ser, root);
        } else {
            serialize.add(ser);
        }
        return ser;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        System.out.println(solution.findDuplicateSubtrees(root));
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