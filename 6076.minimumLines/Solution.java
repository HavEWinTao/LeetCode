import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, (int[] o1, int[] o2) -> {
                    return Integer.compare(o1[0], o2[0]);
                }
        );
        int n = stockPrices.length;
        if (n == 1) {
            return 0;
        }
        int ans = 1;
        long k1 = stockPrices[1][1] - stockPrices[0][1];
        long k2 = stockPrices[1][0] - stockPrices[0][0];
        for (int i = 2; i < n; i++) {
            long k3 = stockPrices[i][1] - stockPrices[i - 1][1];
            long k4 = stockPrices[i][0] - stockPrices[i - 1][0];
            if ((k1 * k4) != (k2 * k3)) {
                ans++;
                k1 = k3;
                k2 = k4;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] stockPrices = new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}};
        //{{1, 1}};
        //{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}};
        //{{3, 4}, {1, 2}, {7, 8}, {2, 3}};
        System.out.println(solution.minimumLines(stockPrices));
    }
}
