import java.util.*;

public class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        }));
        //TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        for (int[] interval : intervals) {
            //Map.Entry<Integer, Integer> leftBound = left.ceilingEntry(interval[1] + 1);
            //if (leftBound != null) {
            //    if (leftBound.getValue() == 1) {
            //        left.remove(leftBound.getKey());
            //    } else {
            //        left.put(leftBound.getKey(), leftBound.getValue() - 1);
            //    }
            //    int cnt = left.getOrDefault(interval[0], 0);
            //    left.put(interval[0], cnt + 1);
            //    continue;
            //}
            Map.Entry<Integer, Integer> rightBound = right.floorEntry(interval[0] - 1);
            if (rightBound != null) {
                if (rightBound.getValue() == 1) {
                    right.remove(rightBound.getKey());
                } else {
                    right.put(rightBound.getKey(), rightBound.getValue() - 1);
                }
                int cnt = right.getOrDefault(interval[1], 0);
                right.put(interval[1], cnt + 1);
                continue;
            }
            //int leftCnt = left.getOrDefault(interval[0], 0);
            //left.put(interval[0], leftCnt + 1);
            int rightCnt = right.getOrDefault(interval[1], 0);
            right.put(interval[1], rightCnt + 1);
        }
        int ans = 0;
        for (int cnt : right.values()) {
            ans += cnt;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {5, 6}, {8, 10}, {11, 13}};
        //{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        System.out.println(solution.minGroups(intervals));
    }
}