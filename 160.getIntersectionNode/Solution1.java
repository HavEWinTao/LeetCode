import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != null && B != null) {
            A = A.next;
            B = B.next;
        }
        if (A == null) A = headB;
        if (B == null) B = headA;
        while (A != null && B != null) {
            A = A.next;
            B = B.next;
        }
        if (B == null) B = headA;
        if (A == null) A = headB;
        while (A != null && B != null) {
            if (A == B) return A;
            A = A.next;
            B = B.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            ListNode listA = new ListNode(4);
            listA.next = new ListNode(1);
            ListNode listB = new ListNode(5);
            listB.next = new ListNode(6);
            listB.next.next = new ListNode(1);

            ListNode in = new ListNode(8);
            in.next = new ListNode(4);
            in.next.next = new ListNode(5);

            listA.next.next = in;
            listB.next.next.next = in;
            ListNode ans = solution.getIntersectionNode(listA, listB);
            System.out.println(ans);
        }
        {
            ListNode listA = new ListNode(1);
            listA.next = new ListNode(9);
            listA.next.next = new ListNode(1);

            ListNode listB = new ListNode(3);

            ListNode in = new ListNode(2);
            in.next = new ListNode(4);

            listA.next.next.next = in;
            listB.next = in;

            ListNode ans = solution.getIntersectionNode(listA, listB);
            System.out.println(ans);
        }
        {
            ListNode listA = new ListNode(2);
            listA.next = new ListNode(6);
            listA.next.next = new ListNode(4);

            ListNode listB = new ListNode(1);
            listB.next = new ListNode(5);

            ListNode ans = solution.getIntersectionNode(listA, listB);
            System.out.println(ans);
        }
    }
}