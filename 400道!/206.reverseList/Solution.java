public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = ans;
            ans = temp;

            head = head.next;
        }
        return ans;
    }
}


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