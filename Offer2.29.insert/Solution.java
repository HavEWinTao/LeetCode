public class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        if (head.next == head) {
            head.next = insertNode;
            insertNode.next = head;
            return head;
        }
        Node parent = head;
        Node cursor = head.next;
        while (cursor != head) {
            if (insertVal >= parent.val && insertVal <= cursor.val) {
                break;
            }
            if (parent.val > cursor.val) {
                if (insertVal > parent.val || insertVal < cursor.val) {
                    break;
                }
            }
            parent = parent.next;
            cursor = cursor.next;
        }
        parent.next = insertNode;
        insertNode.next = cursor;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = head;
        Node ans = solution.insert(head, 2);
        System.out.println("暂停");
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}