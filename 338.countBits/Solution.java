public class Solution {
    //类似于格雷码那种多一位多一位的向上叠加
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int high = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                high = i;
            }
            ans[i] = ans[i - high] + 1;
        }
        return ans;
    }
}
