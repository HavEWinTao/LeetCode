public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        if (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
        } else {
            return null;
        }
        slow = slow.next;
        while (!slow.equals(fast)) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
        }
        ListNode ans = head;
        while (!ans.equals(slow)) {
            ans = ans.next;
            slow = slow.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(-4);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;

        Solution solution = new Solution();
        ListNode ans = solution.detectCycle(head);
        System.out.println("暂停");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
