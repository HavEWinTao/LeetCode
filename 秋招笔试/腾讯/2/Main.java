import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    /*
2
5
2 2 1 3 5
3 1 2 5
4
1 1 1 1
1 2 3
     */
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) fn();
    }


    public static void fn() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();

        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> right = new PriorityQueue<>();
        List<String> ans = new ArrayList<>();
        int remainNum, total = 0;
        for (int i = 0; i < n - 1; i++) total += b[i];
        remainNum = (n + 1) * n / 2 - total;
        b[n - 1] = remainNum;
        for (int i = n - 1; i >= 0; i--) {
            //if (right.isEmpty() || a[b[i] - 1] >= right.peek()) right.add(a[b[i] - 1]);
            //else left.add(a[b[i] - 1]);
            right.add(a[b[i] - 1]);
            while (right.size() - left.size() > 1) {
                left.add(right.poll());
            }
            //while (left.size() - right.size() > 1) {
            //    right.add(left.poll());
            //}
            if (left.size() == 0) {
                ans.add(String.valueOf(right.peek()));
                continue;
            }
            if (left.size() == right.size()) {
                int num1 = left.peek();
                int num2 = right.peek();
                if ((num1 + num2) % 2 == 1) ans.add(String.format("%.1f", (num1 + num2) * 1.0 / 2));
                else ans.add(String.valueOf((num1 + num2) / 2));
                continue;
            }
            ans.add(String.valueOf(left.peek()));
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i));
            System.out.print(i == 0 ? '\n' : ' ');
        }
    }
}