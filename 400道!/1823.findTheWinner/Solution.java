public class Solution {
    public int findTheWinner(int n, int k) {
        LNode linkList = new LNode(1);
        LNode head = linkList;
        for (int i = 2; i <= n; i++) {
            LNode temp = new LNode(i);
            head.next = temp;
            head = temp;
        }
        head.next = linkList;
        LNode iter = head;
        while (n > 1) {
            for (int i = 1; i < k; i++) {
                iter = iter.next;
            }
            iter.next = iter.next.next;
            n--;
        }
        return iter.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheWinner(5, 2));
    }
}

class LNode {
    int val;
    LNode next;

    LNode(int val) {
        this.val = val;
    }
}