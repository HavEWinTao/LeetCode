import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        Arrays.sort(a);
        int i = 0, j = n - 1;
        long init = 0;
        long ans = 0;
        boolean flag = true;
        while (i <= j) {
            if (flag) {
                if (init < a[j]) {
                    ans += a[j] - init;
                    init += a[j] - init;
                } else {
                    init = a[j];
                }
                j--;
            } else {
                if (init < a[i]) {
                    ans += a[i] - init;
                    init += a[i] - init;
                } else {
                    init = a[i];
                }
                i++;
            }
            flag = !flag;
        }
        System.out.println(ans);
    }
}