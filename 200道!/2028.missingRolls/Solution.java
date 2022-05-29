import java.util.Arrays;

public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        for (int roll : rolls) {
            sum -= roll;
        }
        int base = sum / n;
        int remain = sum % n;
        int[] ans = new int[n];
        if (base > 6) {
            return new int[0];
        }
        if (base < 1) {
            return new int[0];
        }
        if (remain == 0) {
            for (int i = 0; i < n; i++) {
                ans[i] = base;
            }
        } else {
            if (base == 6) {
                return new int[0];
            }
            for (int i = 0; i < remain; i++) {
                ans[i] = base + 1;
            }
            for (int i = remain; i < n; i++) {
                ans[i] = base;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] rolls = new int[]{3, 2, 3, 5, 4, 5, 1, 1};
        System.out.println(Arrays.toString(solution.missingRolls(rolls, 5, 8)));
    }
}
