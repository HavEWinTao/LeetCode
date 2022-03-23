import java.util.HashSet;
import java.util.Set;

public class Solution {
    //节点数量最大是10000
    public boolean hasCycle(ListNode head) {
        int cnt = 10000;
        while (cnt >= 0) {
            if (head != null) {
                head = head.next;
                cnt--;
            } else {
                break;
            }
        }
        return !(cnt >= 0);
    }

    //快慢指针
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //哈希表
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
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