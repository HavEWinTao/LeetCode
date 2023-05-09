public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            if (price < minPrice) {//更新最低价格
                minPrice = price;
            } else if ((price - minPrice) > ans) {//更新最低价格这天不会卖
                ans = price - minPrice;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //  2 11      1 6
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        //int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices));
    }
}
