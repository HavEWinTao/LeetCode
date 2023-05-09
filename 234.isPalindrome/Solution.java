import java.util.List;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }
        first = head;
        second = second.next;
        second = reverseList(second);
        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

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

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        list.next = l1;
        l1.next = l2;
        l2.next = l3;

        System.out.println(solution.isPalindrome(list));
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }