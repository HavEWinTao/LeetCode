import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right){
            return head;
        }
        ListNode ret = head;
        ListNode temp = null;
        int i = 1;
        while (i++<left) {
            if (temp==null){
                temp = head;
            } else {
                temp = temp.next;
            }
            head = head.next;
        }
        if (temp==null){
            return reverseList(head,right-left+1);
        }
        temp.next = reverseList(head,right-left+1);
        return ret;
    }

    public ListNode reverseList(ListNode head,int num) {
        ListNode ret = new ListNode();
        ListNode tail = null;
        int cnt = 0;
        while(head!=null && cnt<num){
            //找到当前节点
            ListNode node = head;
            head = head.next;
            // 保持尾部不变
            if (tail==null){
                tail = node;
            }
            tail.next = node.next;
            //头插
            node.next = ret.next;
            ret.next = node;
            cnt++;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            int left = 2, right = 4;
            ListNode ret = solution.reverseBetween(head, left, right);
            System.out.println(1);
        }
        {
            ListNode head = new ListNode(3);
            head.next = new ListNode(5);
            int left = 1, right = 1;
            ListNode ret = solution.reverseBetween(head, left, right);
            System.out.println(1);
        }
    }
}