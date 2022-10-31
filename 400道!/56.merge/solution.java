import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int length = intervals.length;
        boolean[] flag = new boolean[length];
        for (int i = 0; i < length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            } else {
                flag[i] = true;
            }
        }
        flag[length - 1] = true;
        for (int i = 0; i < length; i++) {
            if (flag[i]) {
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
            }
        }
        int size = list.size() / 2;
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            ans[i][0] = list.get(2 * i);
            ans[i][1] = list.get(2 * i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        int[][] ans = solution.merge(intervals);
        for (int[] temp : ans) {
            System.out.println(temp[0] + "-->" + temp[1]);
        }
    }
}
