import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a;
        int b;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (map.containsKey(a)) {
                int temp = map.get(a);
                if (b > temp) map.put(a, b);
            } else {
                map.put(a, b);
            }
        }
        List<Integer[]> list = new ArrayList<>(map.size());
        for (int key : map.keySet()) {
            list.add(new Integer[]{key, map.get(key)});
        }
        list.sort((o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        int max = -1;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (Integer[] integers : list) {
            max = Math.max(max, integers[1]);
            treeMap.put(integers[0], max);
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            int x = sc.nextInt();
            if (x < list.get(0)[0]) {
                System.out.println(-1);
                continue;
            }
            System.out.println(treeMap.floorEntry(x).getValue());
        }
    }
}