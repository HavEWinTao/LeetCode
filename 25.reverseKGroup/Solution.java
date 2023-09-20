import java.util.*;

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode start = temp;
        int cnt = 0;
        ListNode ret = temp;
        while (temp.next != null) {
            if (cnt == 0) {
                start = temp;
            }
            cnt++;

            if (cnt == k) {
                temp = start.next;
                start.next = reverse(start.next, k);
                cnt = 0;
            } else temp = temp.next;
        }
        return ret.next;
    }

    public ListNode reverse(ListNode start, int k) {
        ListNode ret = new ListNode();
        ListNode tail = ret.next;
        while (k-- > 0) {
            ListNode next = start.next;
            if (tail == null) tail = start;
            start.next = ret.next;
            ret.next = start;
            start = next;
        }
        tail.next = start;
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
            ListNode ans = solution.reverseKGroup(head, 2);
            System.out.println(ans);
        }
    }
}