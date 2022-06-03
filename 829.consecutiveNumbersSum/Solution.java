public class Solution {
    public int consecutiveNumbersSum(int n) {
        //运用等差数列的和n，k，a必须为整数的性质
        int ans = 0;
        for (int i = 1; i * i < 2 * n; i++) {
            if ((2 * n) % i != 0) {
                continue;
            }
            if (((2 * n) / i - i + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
