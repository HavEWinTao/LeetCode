import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return partition(head, null);
    }

    public ListNode partition(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode left = partition(head, slow);
        ListNode right = partition(slow, tail);
        ListNode merge = new ListNode();
        ListNode cursor = merge;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cursor.next = left;
                left = left.next;
            } else {
                cursor.next = right;
                right = right.next;
            }
            cursor = cursor.next;
        }
        if (left != null) cursor.next = left;
        if (right != null) cursor.next = right;
        return merge.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            ListNode n1 = new ListNode(4);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(1);
            ListNode n4 = new ListNode(3);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            ListNode ans = solution.sortList(n1);
            System.out.println(ans);
        }
        {
            ListNode n1 = new ListNode(-1);
            ListNode n2 = new ListNode(5);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(4);
            ListNode n5 = new ListNode(0);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            ListNode ans = solution.sortList(n1);
            System.out.println(ans);
        }
        {
            ListNode ans = solution.sortList(null);
            System.out.println(ans);
        }
        {
            ListNode n1 = new ListNode(-1);
            ListNode n2 = new ListNode(5);
            n1.next = n2;
            ListNode ans = solution.sortList(n1);
            System.out.println(ans);
        }
    }
}