class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode temp = new ListNode();
        ListNode ret = temp;
        temp.next = head;
        for (int i = 1; i < left; i++) temp = temp.next;

        temp.next = reverse(temp.next, right - left + 1);
        return ret.next;
    }

    public ListNode reverse(ListNode head, int cnt) {
        ListNode ret = new ListNode();
        ListNode tail = null;
        for (int i = 0; i < cnt; i++) {
            ListNode next = head.next;
            head.next = ret.next;
            ret.next = head;
            if (tail == null) tail = head;
            head = next;
        }
        if (tail != null) tail.next = head;
        return ret.next;
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            ListNode listNode = solution.reverseBetween(head, 2, 4);
            System.out.println(listNode);
        }
        {
            ListNode head = new ListNode(3);
            head.next = new ListNode(5);
            ListNode listNode = solution.reverseBetween(head, 1, 2);
            System.out.println(listNode);
        }
    }
}