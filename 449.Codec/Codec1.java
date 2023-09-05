import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec1 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }
        String[] strings = data.split(",");
        return makeTree(Arrays.stream(strings).mapToInt(Integer::parseInt).toArray(), 0, strings.length - 1);
    }

    public TreeNode makeTree(int[] data, int left, int right) {
        int val = data[left];
        TreeNode root = new TreeNode(val);
        if (left == right) {
            return root;
        }
        int idx = binarySearch(data, val, left + 1, right);
        if (idx - 1 >= left + 1) {
            root.left = makeTree(data, left + 1, idx - 1);
        }
        if (right >= idx) {
            root.right = makeTree(data, idx, right);
        }
        return root;
    }

    public int binarySearch(int[] data, int val, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            int mid = (i + j) / 2;
            if (data[mid] < val) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (i == right && data[i] < val) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String serialize = solution.serialize(root);
        TreeNode ret = solution.deserialize(serialize);
        System.out.println(1);
    }
}