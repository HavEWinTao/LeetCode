public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = -1;
        for (int pile : piles) {
            k = Math.max(k, pile);
        }
        int left = 1;
        while (left < k) {
            int mid = (left + k) / 2;
            if (judge(piles, h, mid)) {
                k = mid;
            } else {
                left = mid + 1;
            }
        }
        return k;
    }

    private boolean judge(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                time += pile / k;
            } else {
                time += pile / k + 1;
            }
        }
        return time <= h;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = new int[]{312884470};
        int h = 968709470;
        System.out.println(solution.minEatingSpeed(piles, h));
    }
}
