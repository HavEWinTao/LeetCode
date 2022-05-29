import java.util.*;

public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> numMap = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (numMap.containsKey(arr[i])) {
                numMap.put(arr[i], numMap.get(arr[i]) + 1);
            } else {
                numMap.put(arr[i], 1);
            }
        }
        Set<Integer> keys = numMap.keySet();
        for (Integer key : keys) {
            if (numMap.get(key) < 0) {
                return false;
            }
            if (numMap.get(key) == 0) {
                continue;
            }
            boolean flag;
            if (key >= 0) {
                flag = numMap.containsKey(key * 2);
                if (flag) {
                    int value = numMap.get(key);
                    numMap.put(key * 2, numMap.get(key * 2) - value);
                }
            } else {
                if (key % 2 != 0) {
                    return false;
                }
                flag = numMap.containsKey(key / 2);
                if (flag) {
                    int value = numMap.get(key);
                    numMap.put(key / 2, numMap.get(key / 2) - value);
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, -2, 2, -4};

        Solution solution = new Solution();
        System.out.println(solution.canReorderDoubled(arr));
    }
}
