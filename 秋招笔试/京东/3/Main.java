import java.util.*;

// 找规律
/*
1 2 3 4 5 len=5
1 (len-0)*1*nums[0]
1 2 (len-1)*2*nums[1]
1 2 3 (len-2)*3*nums[2]
1 2 3 4 (len-3)*4*nums[3]
1 2 3 4 5 (len-4)*5*nums[4]

4*2*nums[3] + 3*2*nums[3] + 2*2*nums[3] + 1*2*nums[3]
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        long mod = (long) (1e9 + 7);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long len = i + 1;
            long cnt = n - i;
            long tx = len * (len + 1) / 2 * cnt * a[i];
            ans = (ans + tx) % mod;
        }
        System.out.println(ans);
    }
}