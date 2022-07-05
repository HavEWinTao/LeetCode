import java.util.Arrays;

public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int i = 0, j = 0;
        int state = 0;
        long cnt = 0;
        long total = ((long) m) * ((long) n);
        int boundx = 0, boundy = 0;
        while (cnt < total) {
            int val = -1;
            if (head != null) {
                val = head.val;
                head = head.next;
            }
            switch (state) {
                case 0: {
                    if (j < n) {
                        ans[i][j] = val;
                        j++;
                        if (j == n) {
                            j--;
                            i++;
                            state = 1;
                            boundx++;
                        }
                    }
                    break;
                }
                case 1: {
                    if (i < m) {
                        ans[i][j] = val;
                        i++;
                        if (i == m) {
                            i--;
                            j--;
                            state = 2;
                            n--;
                        }
                    }
                    break;
                }
                case 2: {
                    if (j >= boundy) {
                        ans[i][j] = val;
                        j--;
                        if (j < boundy) {
                            j++;
                            i--;
                            state = 3;
                            m--;
                        }
                    }
                    break;
                }
                case 3: {
                    if (i >= boundx) {
                        ans[i][j] = val;
                        i--;
                        if (i < boundx) {
                            i++;
                            j++;
                            state = 0;
                            boundy++;
                        }
                    }
                    break;
                }
            }
            cnt++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(7);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(4);
        ListNode l9 = new ListNode(2);
        ListNode l10 = new ListNode(5);
        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(0);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = l12;
        System.out.println(Arrays.deepToString(solution.spiralMatrix(3, 5, head)));
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
