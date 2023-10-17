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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> val2idx1 = new HashMap<>();
        for (int i = 0; i < n; i++) val2idx1.put(preorder[i], i);
        Map<Integer, Integer> val2idx2 = new HashMap<>();
        for (int i = 0; i < n; i++) val2idx2.put(inorder[i], i);
        return build(preorder, val2idx1, 0, n - 1, inorder, val2idx2, 0, n - 1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> val2idx1, int left1, int right1, int[] inorder, Map<Integer, Integer> val2idx2, int left2, int right2) {
        if (left1 > right1 || left2 > right2) return null;
        if (left1 == right1) return new TreeNode(preorder[left1]);
        int val = preorder[left1];
        int idx = val2idx2.get(val);
        TreeNode node = new TreeNode(val);
        int preIdx = left1 + idx - left2;
        node.left = build(preorder, val2idx1, left1 + 1, preIdx, inorder, val2idx2, left2, idx - 1);
        node.right = build(preorder, val2idx1, preIdx + 1, right1, inorder, val2idx2, idx + 1, right2);

        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            int[] preorder = new int[]{3, 9, 20, 15, 7};
            int[] inorder = new int[]{9, 3, 15, 20, 7};
            TreeNode root = solution.buildTree(preorder, inorder);
            System.out.println(root);
        }
        {
            int[] preorder = new int[]{1, 2};
            int[] inorder = new int[]{1, 2};
            TreeNode root = solution.buildTree(preorder, inorder);
            System.out.println(root);
        }
        {
            int[] preorder = new int[]{1, 2, 3};
            int[] inorder = new int[]{3, 2, 1};
            TreeNode root = solution.buildTree(preorder, inorder);
            System.out.println(root);
        }
    }
}