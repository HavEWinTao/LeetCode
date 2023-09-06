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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, TreeNode> val2Node = new HashMap<>();
        dfs1(root, map, val2Node);
        int node = dfs2(root, map);
        return val2Node.get(node);
    }

    public int dfs1(TreeNode root, Map<Integer, Integer> map, Map<Integer, TreeNode> val2Node) {
        if (root == null) {
            return 0;
        }
        val2Node.put(root.val, root);
        int left = dfs1(root.left, map, val2Node);
        int right = dfs1(root.right, map, val2Node);
        int depth = Math.max(left, right) + 1;
        map.put(root.val, depth);
        return depth;
    }

    public int dfs2(TreeNode root, Map<Integer, Integer> map) {
        int left = -1;
        if (root.left != null) {
            left = map.get(root.left.val);
        }
        int right = -1;
        if (root.right != null) {
            right = map.get(root.right.val);
        }
        if (left == right) {
            return root.val;
        }
        if (left < right) {
            return dfs2(root.right, map);
        }
        return dfs2(root.left, map);
    }

    public static void main(String[] args) {
        Main solution = new Main();
        {

        }
    }
}