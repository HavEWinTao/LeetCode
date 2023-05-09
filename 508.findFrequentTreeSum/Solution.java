import java.util.*;

public class Solution {

    private Map<Integer, Integer> cntSum = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        int sum = getSum(root);
        Integer maxCnt = Collections.max(cntSum.values());
        List<Integer> ans = new ArrayList<>();
        cntSum.forEach((key, value) -> {
            if (Objects.equals(value, maxCnt)) {
                ans.add(key);
            }
        });
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + getSum(root.left) + getSum(root.right);
        int cnt = cntSum.getOrDefault(sum, 0);
        cntSum.put(sum, cnt + 1);
        return sum;
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