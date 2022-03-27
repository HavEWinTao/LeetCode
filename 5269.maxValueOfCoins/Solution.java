import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for (List<Integer> pile : piles) {
            for (int i = 1; i < pile.size(); i++) {
                pile.set(i, pile.get(i) + pile.get(i - 1));
            }
        }//我只想到了这
        int[][] dp = new int[piles.size() + 1][k + 1];//dp[i]表示取i个硬币时的最大值
        for (int index = 1; index <= piles.size(); index++) {
            List<Integer> pile = piles.get(index - 1);
            for (int i = 1; i <= k; i++) {
                dp[index][i] = dp[index - 1][i];
                for (int j = 1; j <= i && j <= pile.size(); j++) {
                    dp[index][i] = Math.max(dp[index][i], dp[index - 1][i - j] + pile.get(j - 1));
                }
            }
        }
        return dp[piles.size()][k];
    }

    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Collections.addAll(temp, 80, 62, 78, 78, 40, 59, 98, 35);
        piles.add(new ArrayList<>(temp));
        temp.clear();
        Collections.addAll(temp, 79, 19, 100, 15);
        piles.add(new ArrayList<>(temp));
        temp.clear();
        Collections.addAll(temp, 79, 2, 27, 73, 12, 13, 11, 37, 27, 55, 54, 55, 87, 10, 97, 26, 78, 20, 75, 23, 46, 94, 56, 32, 14, 70, 70, 37, 60, 46, 1, 53);
        piles.add(new ArrayList<>(temp));
        temp.clear();


        Solution solution = new Solution();
        System.out.println(solution.maxValueOfCoins(piles, 25));
    }
}
