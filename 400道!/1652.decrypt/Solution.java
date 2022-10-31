public class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] sum1 = new int[n];
        sum1[0] = code[0];
        for (int i = 1; i < n; i++) {
            sum1[i] = sum1[i - 1] + code[i];
        }
        int[] sum2 = new int[n];
        sum2[n - 1] = code[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum2[i] = sum2[i + 1] + code[i];
        }
        int[] ans = new int[n];
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int bound = i + k;
                if (bound >= n) {
                    ans[i] += sum1[n - 1] - sum1[i];
                    int temp = bound - n;
                    ans[i] += sum1[temp];
                } else {
                    ans[i] += sum1[bound] - sum1[i];
                }
            }
        }
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                ans[i] = 0;
            }
        }
        if (k < 0) {
            for (int i = 0; i < n; i++) {
                int bound = i + k;
                if (bound < 0) {
                    ans[i] += sum2[0] - sum2[i];
                    int temp = bound + n;
                    ans[i] += sum2[temp];
                } else {
                    ans[i] += sum2[bound] - sum2[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main solution = new Main();
        int[] code = new int[]{5, 7, 1, 4};
        System.out.println(Arrays.toString(solution.decrypt(code, 3)));
    }
}