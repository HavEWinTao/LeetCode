import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] data = sc.nextLine().toCharArray();
            Arrays.sort(data);
            String str = String.copyValueOf(data);
            int cnt = count.getOrDefault(str, 0);
            count.put(str, cnt + 1);
        }
        long ans = 0;
        for (String key : count.keySet()) {
            int value = count.get(key);
            ans += (long) value * (value - 1) / 2;
        }
        System.out.println(ans);
    }
}