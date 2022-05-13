import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val) + " ";
        }
        return root.val + " " + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }
        String[] nodes = data.split(" ");
        return makeTree(nodes);
    }

    public TreeNode makeTree(String[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        int value = Integer.parseInt(nodes[0]);
        TreeNode root = new TreeNode(value);
        if (nodes.length == 1) {
            return root;
        }
        int index = 1;
        while (index < nodes.length && Integer.parseInt(nodes[index]) < value) {
            index++;
        }
        String[] leftString = Arrays.copyOfRange(nodes, 1, index);
        String[] rightString = Arrays.copyOfRange(nodes, index, nodes.length);
        root.left = makeTree(leftString);
        root.right = makeTree(rightString);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
//        TreeNode r1 = new TreeNode(10);
        root.left = l1;
//        root.right = r1;
//        TreeNode l21 = new TreeNode(2);
//        TreeNode l22 = new TreeNode(4);
//        l1.left = l21;
//        l1.right = l22;
//        TreeNode r21 = new TreeNode(7);
//        TreeNode r22 = new TreeNode(11);
//        r1.left = r21;
//        r1.right = r22;
        String data = codec.serialize(root);
        System.out.println(data);
        TreeNode t = codec.deserialize(data);
        System.out.println("暂停");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}