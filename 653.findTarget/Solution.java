import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {

    private List<Integer> values;

    public boolean findTarget(TreeNode root, int k) {
        values = new ArrayList<>();
        midDFS(root);
        int right = values.size() - 1;
        int left = 0;
        while (left < right) {
            if (values.get(left) + values.get(right) > k) {
                right--;
            } else if (values.get(left) + values.get(right) < k) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

    public void midDFS(TreeNode root) {
        if (root != null) {
            midDFS(root.left);
            values.add(root.val);
            midDFS(root.right);
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