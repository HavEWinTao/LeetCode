import java.util.ArrayDeque;
import java.util.Queue;

//2022-3-20
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return judge(p.left, q.right) && judge(p.right, q.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(4);
        TreeNode t33 = new TreeNode(4);
        TreeNode t34 = new TreeNode(3);
        t1.left = t21;
        t1.right = t22;
        t21.left = t31;
        t21.right = t32;
        t22.left = t33;
        t22.right = t34;
        System.out.println(solution.isSymmetric(t1));
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