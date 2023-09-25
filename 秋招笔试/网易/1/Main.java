import java.util.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            boolean ret = fn();
            if (ret) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean fn() {
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        if (n % 2 == 1) return true;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) list1.add(nums[i]);
            else list2.add(nums[i]);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int idx1 = 0;
        int idx2 = 0;
        int pre = list1.get(0);
        while (idx1 < list1.size() && idx2 < list2.size()) {
            if (list1.get(idx1) < pre) return false;
            pre = list1.get(idx1++);
            if (list2.get(idx2) < pre) return false;
            pre = list2.get(idx2++);
        }
        return true;
    }
}