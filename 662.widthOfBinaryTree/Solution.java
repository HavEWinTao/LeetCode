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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = 1;
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = queue.peek().val;
            int right = left;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                right = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                    node.left.val = node.val * 2;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    node.right.val = node.val * 2 + 1;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
        System.out.println(solution.widthOfBinaryTree(root));
    }
}