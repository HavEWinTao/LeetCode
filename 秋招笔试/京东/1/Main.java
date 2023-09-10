import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] num2cnt = new int[100010];
        for (int i=0;i<n;i++) {
            a[i] = sc.nextInt();
            num2cnt[a[i]]++;
        }
        long ans = 0;
        for (int i=num2cnt.length-1;i>=0;i--){
            while (num2cnt[i]>0){
                num2cnt[i]--;
                for (int j=0;j<=k;j++){
                    if (i-j>0 && num2cnt[i-j]>0){
                        num2cnt[i-j]--;
                        ans += (long) i *(i-j);
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}