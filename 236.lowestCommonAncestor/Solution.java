import java.util.*;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //通过当前节点查找父节点
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        DFS(root, parent);
        parent.put(root, null);
        Set<TreeNode> qParent = new HashSet<>();
        do {
            qParent.add(q);
            q = parent.get(q);
        } while (parent.containsKey(q));

        while (!qParent.contains(p)) {
            p = parent.get(p);
        }
        return p;
    }

    public void DFS(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root.left != null) {
            parent.put(root.left, root);
            DFS(root.left, parent);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            DFS(root.right, parent);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode l11 = new TreeNode(0);
        TreeNode l12 = new TreeNode(3);
        root.left = l11;
        root.right = l12;

        TreeNode l21 = new TreeNode(-2);
        TreeNode l22 = new TreeNode(4);
        l11.left = l21;
        l11.right = l22;

        TreeNode l31 = new TreeNode(8);
        l21.left = l31;

        Solution solution = new Solution();
        TreeNode ans = solution.lowestCommonAncestor(root, l31, root);
        System.out.println("暂停");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}