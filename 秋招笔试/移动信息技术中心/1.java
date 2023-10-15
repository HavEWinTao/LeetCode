import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] data = sc.nextLine().toCharArray();
        int n = data.length;
        int ans = 1;
        int idx = 0;
        int tail = idx;
        while (tail < n) {
            if (data[idx] == data[tail]) {
                tail++;
                ans = Math.max(ans, tail - idx);
            } else idx = tail;
        }
        if (data[0] == data[n - 1]) {
            int start = 0;
            while (start < n && data[start] == data[0]) start++;
            int end = n - 1;
            while (end >= 0 && data[end] == data[n - 1]) end--;
            if (start == n) {
                System.out.println(n);
                return;
            }
            ans = Math.max(ans, start + n - end - 1);
        }
        System.out.println(ans);
    }
}