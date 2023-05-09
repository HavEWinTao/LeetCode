//2022-3-19
import java.util.*;

public class Solution {
    private List<Integer> ans = new ArrayList<>();
    private int n;

    //效率太低了
    public List<Integer> lexicalOrder(int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            temp.add(String.valueOf(i));
        }
        temp.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        List<Integer> ans = new ArrayList<>();
        for (String item : temp) {
            ans.add(Integer.valueOf(item));
        }
        return ans;
    }

    //按字典序直接生成
    public List<Integer> lexicalOrder2(int n) {
        this.n = n;
        TreeNode root = new TreeNode(0);
        makeTree(root);
        preDFS(root);
        ans.remove(0);
        return ans;
    }

    private void makeTree(TreeNode root) {
        ArrayList<TreeNode> child = new ArrayList<>();
        int base = root.val * 10;
        for (int i = 0; i <= 9; i++) {
            int temp = base + i;
            if (temp == 0) {
                continue;
            }
            if (temp <= n) {
                child.add(new TreeNode(temp));
            } else {
                break;
            }
        }
        root.child = child;
        for (TreeNode t : root.child) {
            makeTree(t);
        }
    }

    private void preDFS(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        if (root.child != null) {
            for (TreeNode t : root.child) {
                preDFS(t);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> ans1 = solution.lexicalOrder(133);

        List<Integer> ans2 = solution.lexicalOrder2(133);

        System.out.println(ans1.equals(ans2));
    }
}
