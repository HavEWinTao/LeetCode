import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {//从小到大
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o2[1], o1[1]);//从大到小
        });
        int n = intervals.length;
        //初始的两个元素
        int cur = intervals[n - 1][0];
        int next = intervals[n - 1][0] + 1;
        int ans = 2;
        //从后向前遍历
        for (int i = n - 2; i >= 0; i--) {
            //开始分类讨论
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                cur = intervals[i][0];
                next = intervals[i][0] + 1;
                ans = ans + 2;
            } else {//intervals[i][1]==cur
                next = cur;
                cur = intervals[i][0];
                ans++;
            }
        }
        return ans;
    }
}
