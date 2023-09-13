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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                TreeNode peek = queue.poll();
                if (peek.left != null) queue.offer(peek.left);
                if (peek.right != null) queue.offer(peek.right);
                if (i == size) ans.add(peek.val);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
        }
    }
}