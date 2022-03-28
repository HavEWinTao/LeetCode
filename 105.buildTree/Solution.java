import java.util.Arrays;

public class Solution {
    //Arrays.copyofRange包括左面，不包括右面[from,to)
    //这个程序的执行用时和内存消耗有点高，原因是Arrays.copyOfRang,可以使用四个数来标记区间来降低
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootVal = preorder[0];
        int index;
        for (index = 0; index < inorder.length; index++) {
            if (rootVal == inorder[index]) {
                break;
            }
        }
        int left = index;
        int right = inorder.length - index - 1;
        TreeNode root = new TreeNode();
        root.val = rootVal;
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, left + 1), Arrays.copyOfRange(inorder, 0, left));
        root.right = buildTree(Arrays.copyOfRange(preorder, left + 1, left + right + 1), Arrays.copyOfRange(inorder, index + 1, index + right + 1));
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2};
        int[] inorder = new int[]{2, 1};

        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println("暂停");
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