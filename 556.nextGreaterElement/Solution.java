import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> slice = new ArrayList<>();
        while (n != 0) {
            slice.add(n % 10);
            n /= 10;
        }
        Collections.reverse(slice);
        int length = slice.size();
        int index1 = length - 2;
        while (index1 >= 0 && (slice.get(index1) >= slice.get(index1 + 1))) {
            index1--;
        }
        if (index1 < 0) {
            return -1;
        }
        int index2 = length - 1;
        while (index2 >= 0 && slice.get(index2) <= slice.get(index1)) {
            index2--;
        }
        int temp = slice.get(index1);
        slice.set(index1, slice.get(index2));
        slice.set(index2, temp);
        List<Integer> rev = slice.subList(index1 + 1, length);
        Collections.reverse(rev);
        long ans = 0;
        for (Integer integer : slice) {
            ans = ans * 10 + integer;
        }
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 230241;
        System.out.println(solution.nextGreaterElement(n));
        System.out.println("暂停");
    }
}
