import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    private int ans = 0;

    public int pathNumber(TreeNode root) {
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int cnt0, int cnt1) {
        if (root.val == 0) cnt0++;
        if (root.val == 1) cnt1++;
        if (root.left == null && root.right == null) {
            if (cnt1 > cnt0) {
                ans++;
            }
            return;
        }
        if (root.left != null) dfs(root.left, cnt0, cnt1);
        if (root.right != null) dfs(root.right, cnt0, cnt1);
    }

    public static void main(String[] args) {
        Main solution = new Main();
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(0);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(0);
            root.right = new TreeNode(0);
            root.right.right = new TreeNode(1);
            int ans = solution.pathNumber(root);
            System.out.println(ans);
        }
    }
}