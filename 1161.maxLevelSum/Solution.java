import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxValue = root.val;
        int index = 1;
        int ans = index;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int value = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                value += temp.val;
            }
            if (value > maxValue) {
                ans = index;
                maxValue = value;
            }
            index++;
        }
        return ans;
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