//2022-3-19
public class Solution {
    public int climbStairs(int n) {
        int[] ans = new int[100];
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        System.out.println(solution.climbStairs(n));
    }
}
