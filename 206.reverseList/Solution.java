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

    // 不需要额外空间
    // 新建个头结点，遍历一次链表将每个节点头插就是逆序
    public ListNode reverseList2(ListNode head) {
        ListNode ret = new ListNode();
        while(head!=null){
            ListNode node = head;
            head = head.next;
            node.next = ret.next;
            ret.next = node;
        }
        return ret.next;
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