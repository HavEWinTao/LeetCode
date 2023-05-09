import java.util.*;

public class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int ans = 0;
        int maxScore = 0, maxCnt = 0;
        int cnt = 0, score = 0;
        boolean flag = false;
        for (int i = 0; i < grades.length; i++) {
            if (cnt <= maxCnt || score <= maxScore) {
                cnt++;
                score += grades[i];
            } else {
                ans++;
                maxScore = score;
                maxCnt = cnt;
                score = 0;
                cnt = 0;
                if (i == grades.length - 1) {
                    flag = true;
                }
                //不要有i--
            }
        }
        if (!flag) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] grades = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        //{10, 6, 12, 7, 3, 5};
        System.out.println(solution.maximumGroups(grades));
    }
}
