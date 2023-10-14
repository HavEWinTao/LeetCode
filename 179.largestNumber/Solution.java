import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) data[i] = nums[i];
        Arrays.sort(data, (x, y) -> {
            long sx = 10;
            while (sx <= x) sx *= 10;
            long sy = 10;
            while (sy <= y) sy *= 10;
            return Long.compare(sx * y + x, sy * x + y);
        });
        if (data[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : data) sb.append(num);
        return sb.toString();
    }
}