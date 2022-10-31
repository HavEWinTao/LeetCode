import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Codec {
    private int index;

    public String serialize(TreeNode root) {
        if (root == null) {
            return "# ";
        }
        return root.val + " " + serialize(root.left) + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        index = 0;
        return rdeserialize(nodes);
    }

    private TreeNode rdeserialize(String[] nodes) {
        if (nodes[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        root.left = rdeserialize(nodes);
        root.right = rdeserialize(nodes);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(4);
        TreeNode l1 = new TreeNode(-7);
        TreeNode r1 = new TreeNode(-3);
        root.left = l1;
        root.right = r1;
        TreeNode r21 = new TreeNode(-9);
        TreeNode r22 = new TreeNode(-3);
        r1.left = r21;
        r1.right = r22;
        r21.left = new TreeNode(9);
        r21.right = new TreeNode(-7);
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