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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = new ListNode();
        ListNode ans = ret;
        ret.next = head;
        while (ret.next != null) {
            if (ret.next.next != null && ret.next.val == ret.next.next.val) {
                int val = ret.next.val;
                ListNode temp = ret.next;
                while (temp != null && temp.val == val) {
                    temp = temp.next;
                }
                ret.next = temp;
            } else ret = ret.next;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(3);
            ListNode n5 = new ListNode(4);
            ListNode n6 = new ListNode(4);
            ListNode n7 = new ListNode(5);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            n5.next = n6;
            n6.next = n7;
            ListNode ans = solution.deleteDuplicates(n1);
            System.out.println(ans);
        }
        {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(1);
            ListNode n3 = new ListNode(1);
            ListNode n4 = new ListNode(2);
            ListNode n5 = new ListNode(3);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            ListNode ans = solution.deleteDuplicates(n1);
            System.out.println(ans);
        }
    }
}