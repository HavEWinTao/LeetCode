import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] startTime = new int[]{1, 1, 2, 3};
        int[] endTime = new int[]{5, 3, 2, 7};
        int queryTime = 4;
        System.out.println(solution.busyStudent(startTime, endTime, queryTime));
    }
}
