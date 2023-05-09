import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return BFS(root);
    }

    public List<List<Integer>> BFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodes.add(queue.poll());
            }
            for (TreeNode node : nodes) {
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = null;
        List<List<Integer>> ans = solution.levelOrder(root);
        System.out.println(ans);
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
