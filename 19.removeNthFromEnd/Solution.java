class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = new ListNode(-1);
        ret.next = head;
        ListNode temp = ret;
        for (int i = 0; i < n; i++) temp = temp.next;
        ListNode cur = ret;
        ListNode last = cur;
        while (temp != null) {
            temp = temp.next;
            last = cur;
            cur = cur.next;
        }
        last.next = last.next.next;
        return ret.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            ListNode listNode = solution.removeNthFromEnd(head, 2);
            System.out.println(1);
        }
    }
}