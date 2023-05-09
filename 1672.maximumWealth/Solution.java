public class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int i = 0; i < accounts.length; i++) {
            int add = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                add += accounts[i][j];
            }
            if (add > ans) {
                ans = add;
            }
        }
        return ans;
    }
}
