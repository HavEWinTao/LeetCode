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

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }

    public void dfs(List<Integer> list, TreeNode node) {
        if (node.left != null) dfs(list, node.left);
        list.add(node.val);
        if (node.right != null) dfs(list, node.right);
    }
}