import java.util.*;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        int con = pairs[0][1];
        int index = 1;
        int ans = 1;
        while (index < n) {
            if (pairs[index][0] > con) {
                con = pairs[index][1];
                while (index < n && con == pairs[index][1]) {
                    index++;
                }
                ans++;
            } else {
                index++;
            }
        }
        return ans;
    }
}