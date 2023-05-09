import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        DFS(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        DFS(root2, l2);
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                ans.add(l1.get(i));
                i++;
            } else {
                ans.add(l2.get(j));
                j++;
            }
        }
        while (i < l1.size()) {
            ans.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            ans.add(l2.get(j));
            j++;
        }
        return ans;
    }

    private void DFS(TreeNode root, List<Integer> list) {
        if (root != null) {
            DFS(root.left, list);
            list.add(root.val);
            DFS(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        TreeNode r1l = new TreeNode(1);
        TreeNode r1r = new TreeNode(4);
        TreeNode ll1 = new TreeNode(3);
        TreeNode ll2 = new TreeNode(7);
        root1.left = r1l;
        root1.right = r1r;
        r1r.left = ll1;
        r1r.right = ll2;

        TreeNode root2 = new TreeNode(1);
        TreeNode r2l = new TreeNode(0);
        TreeNode r2r = new TreeNode(3);
        TreeNode rr1 = new TreeNode(2);
        TreeNode rr2 = new TreeNode(5);
        root2.left = r2l;
        root2.right = r2r;
        r2r.left = rr1;
        r2r.right = rr2;

        Solution solution = new Solution();
        System.out.println(solution.getAllElements(root1, root2));
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