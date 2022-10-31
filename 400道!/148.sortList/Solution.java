public class Solution {
    public ListNode sortList(ListNode head) {
        return mergesort(head, null);
    }

    private ListNode mergesort(ListNode head, ListNode tail) {
        if (head != null && head.next != tail) {
            ListNode mid = head;
            ListNode fast = head;
            while (fast != tail && fast.next != tail) {
                mid = mid.next;
                fast = fast.next.next;
            }

            head = mergesort(head, mid);
            ListNode flag = head;
            while (flag != null && flag.next != mid) {
                flag = flag.next;
            }
            mid = mergesort(mid, tail);
            flag.next = mid;
            head = merge(head, mid, tail, flag);
        }
        return head;
    }

    private ListNode merge(ListNode head, ListNode mid, ListNode tail, ListNode flag) {
        ListNode ans = new ListNode();
        ListNode cursor = ans;
        ListNode node1 = head;
        ListNode node2 = mid;
        while (node1 != mid && node2 != tail) {
            if (node1.val < node2.val) {
                cursor.next = node1;
                node1 = node1.next;
            } else {
                cursor.next = node2;
                node2 = node2.next;
            }
            cursor = cursor.next;
        }
        while (node1 != mid) {
            cursor.next = node1;
            node1 = node1.next;
            cursor = cursor.next;
        }
        while (node2 != tail) {
            cursor.next = node2;
            node2 = node2.next;
            cursor = cursor.next;
        }
        cursor.next = tail;
        return ans.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(0);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = solution.sortList(head);
        System.out.println("pause");
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