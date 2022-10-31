import java.util.Arrays;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            //从小到大
            return Integer.compare(o1[0], o2[0]);
        });
        //将身高从小到大排序后后放置的人对先放置的人不产生影响
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                //因为是大于等于，所以得找空位和身高相等的，找位置
                if (ans[i] == null || ans[i][0] == person[0]) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
