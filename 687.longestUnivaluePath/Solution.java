import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                int leftLength = 0;
                int rightLength = 0;
                if (t.left != null && t.right != null) {
                    queue.add(t.left);
                    queue.add(t.right);
                    if (t.left.val == t.val) {
                        leftLength = 1 + DFS(t.left);
                    }
                    if (t.right.val == t.val) {
                        rightLength = 1 + DFS(t.right);
                    }
                    ans = Math.max(ans, leftLength + rightLength);
                } else if (t.left == null && t.right != null) {
                    queue.add(t.right);
                    if (t.right.val == t.val) {
                        rightLength = 1 + DFS(t.right);
                    }
                    ans = Math.max(ans, rightLength);
                } else if (t.left != null && t.right == null) {
                    queue.add(t.left);
                    if (t.left.val == t.val) {
                        leftLength = 1 + DFS(t.left);
                    }
                    ans = Math.max(ans, leftLength);
                }
            }
        }
        return ans;
    }

    public int DFS(TreeNode root) {
        int val = root.val;
        if (root.left != null && root.right != null) {
            int left = 0;
            if (root.left.val == val) {
                left = 1 + DFS(root.left);
            }
            int right = 0;
            if (root.right.val == val) {
                right = 1 + DFS(root.right);
            }
            return Math.max(left, right);
        } else if (root.left == null && root.right != null) {
            int right = 0;
            if (root.right.val == val) {
                right = 1 + DFS(root.right);
            }
            return right;
        } else if (root.left != null && root.right == null) {
            int left = 0;
            if (root.left.val == val) {
                left = 1 + DFS(root.left);
            }
            return left;
        } else {
            return 0;
        }
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
