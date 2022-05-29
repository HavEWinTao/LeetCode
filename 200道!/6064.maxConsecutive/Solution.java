import java.util.Arrays;

public class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = -1;
        int i = bottom;
        for (int j = 0; j < special.length; j++) {
            ans = Math.max(ans, special[j] - i);
            i = special[j] + 1;
        }
        return Math.max(ans, top - i + 1);
    }
}
