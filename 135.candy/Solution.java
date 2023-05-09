public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] num = new int[n];
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                num[i] = num[i - 1] + 1;
            } else {
                num[i] = 1;
            }
        }
        int ans = num[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                num[i] = Math.max(num[i], num[i + 1] + 1);
            }
            ans += num[i];
        }
        return ans;
    }
}
