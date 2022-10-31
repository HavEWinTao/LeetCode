public class Solution {
    private int ans = 0;
    //思路没错，时间多是因为每个节点都进行了一次求深度而不是记录深度
    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);
        return ans;
    }

    public void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = calDepth(root.left);
        int right = calDepth(root.right);
        if (left + right > ans) {
            ans = left + right;
        }
        DFS(root.left);
        DFS(root.right);
    }

    public int calDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {
            return 1 + calDepth(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + calDepth(root.left);
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return (1 + Math.max(calDepth(root.left), calDepth(root.right)));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode t11 = new TreeNode(2);
        TreeNode t12 = new TreeNode(3);
        TreeNode t21 = new TreeNode(4);
        TreeNode t22 = new TreeNode(5);
        TreeNode t31 = new TreeNode(6);
        TreeNode t32 = new TreeNode(7);
        TreeNode t41 = new TreeNode(8);
        TreeNode t42 = new TreeNode(9);
        root.left = t11;
        root.right = t12;
        t12.left = t21;
        t12.right = t22;
        t21.left = t31;
        t22.right = t32;
        t31.left = t41;
        t32.right = t42;

        System.out.println(solution.diameterOfBinaryTree(root));
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