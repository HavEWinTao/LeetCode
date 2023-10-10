import java.util.*;

/*
meili
ans: 3
 */
/*
meei
ans: 2
 */
public class Solution {

    private static int n;

    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] data = sc.nextLine().toCharArray();
        n = data.length;
        dfs(data, 1, false, new StringBuilder().append(data[0]), false);
        dfs(data, 1, false, new StringBuilder(), true);
        System.out.println(ans);
    }

    private static void dfs(char[] data, int i, boolean flag, StringBuilder sb, boolean flag1) {
        if (!flag && sb.length() >= 3) {
            int length = sb.length();
            if (sb.charAt(length - 1) == 'i' && sb.charAt(length - 2) == 'e' && sb.charAt(length - 3) == 'm') {
                flag = true;
            }
        }
        if (i == n) {
            if (flag) ans++;
            return;
        }
        if (!flag1) {
            StringBuilder sb1 = new StringBuilder(sb);
            dfs(data, i + 1, flag, sb1, true);
        }
        StringBuilder sb2 = new StringBuilder(sb);
        dfs(data, i + 1, flag, sb2.append(data[i]), false);
    }
}