import java.util.ArrayDeque;
import java.util.Queue;

class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                } else {
                    temp.left = new TreeNode(val);
                    return temp.val;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                } else {
                    temp.right = new TreeNode(val);
                    return temp.val;
                }
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
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