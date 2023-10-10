import java.util.*;

/*
5
1 2 3 4 1
3 1 2 3 2
ans: 4
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        int ans = 0;
        int i = n - 1;
        int j = n - 1;
        while ( j >= 0) {
            if (a[i] >= b[j]) {
                ans++;
                i--;
                j--;
            } else {
                j--;
            }
        }
        System.out.println(ans);
    }
}