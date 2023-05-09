public class Solution {
    public int minCostToMoveChips(int[] position) {
        int cnt1 = 0, cnt2 = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        return Math.min(cnt1, cnt2);
    }
}
