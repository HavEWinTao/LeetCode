import java.util.*;

public class Solution {

    /*
    3
    6 4 5 2 10
    4 4 3 4 10
    100 100 1 1 100
     */
    /*
    8
    9
    kou dead.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        long[] cnt = new long[]{-1, 3, 2, 1, 1};
        while (q-- > 0) {
            long a = sc.nextLong();//a个怪
            long b = sc.nextLong();//攻击力
            long x = sc.nextLong();//嘲讽
            long y = sc.nextLong();//技能
            long h = sc.nextLong();
            if (b >= 5) {
                long usey = Math.max(x - a, 0);
                usey = Math.min(usey, y);
                long attack = Math.max(0, a - x);
                h = h + usey * 5 - attack * b;
            } else {
                long usey = Math.min(y, x);
                long attack = Math.max(a - (x - usey) * cnt[(int) b], 0);
                h = h + usey * 5 - attack * b;
            }
            if (h <= 0) System.out.println("kou dead.");
            else System.out.println(h);
        }
    }
}