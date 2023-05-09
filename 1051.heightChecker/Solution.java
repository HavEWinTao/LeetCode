import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int max = Arrays.stream(heights).max().getAsInt();
        int[] bucket = new int[max+1];
        for (int height : heights) {
            bucket[height]++;
        }
        int index = 0;
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                if (heights[index] != i) {
                    ans++;
                }
                index++;
            }
        }
        return ans;
    }
}
