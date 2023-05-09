public class Solution {
    public int numTrees(int n) {
        int[] ans = new int[n + 2];
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                if (left != 0 && right != 0) {
                    ans[i] += (ans[left] * ans[right]);
                } else {
                    ans[i] += (ans[left] + ans[right]);
                }
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(1));
    }
}
