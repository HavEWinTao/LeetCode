class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode end = slow;
        ListNode rev = reverse(mid);
        ListNode ret = new ListNode(-1);
        ListNode tail = ret;
        while (head != end && rev != null) {
            ListNode node1 = head.next;
            ListNode node2 = rev.next;
            tail.next = head;
            tail = tail.next;
            tail.next = rev;
            tail = tail.next;

            head = node1;
            rev = node2;
        }
        if (rev != null) tail.next = rev;
        head = ret.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode ret = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = ret.next;
            ret.next = head;
            head = next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            solution.reorderList(head);
            System.out.println(1);
        }
    }
}