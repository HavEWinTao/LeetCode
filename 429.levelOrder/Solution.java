import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Queue<Node> q = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                temp.add(node.val);
                q.addAll(node.children);
            }
            ans.add(temp);
            queue = q;
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = null;
        Solution solution = new Solution();
        System.out.println(solution.levelOrder(root));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};