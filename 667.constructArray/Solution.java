public class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int index = 0;
        ans[index++] = 1;
        for (int i = 0; i < k - 1; i++) {
            int temp = n - i - 1;
            if (i % 2 == 0) {
                ans[index] = ans[index - 1] + temp;
            } else {
                ans[index] = ans[index - 1] - temp;
            }
            index++;
        }
        for (int i = index; i < n; i++) {
            if (k % 2 == 0) {
                ans[index] = ans[index - 1] - 1;
            } else {
                ans[index] = ans[index - 1] + 1;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.constructArray(6, 4);
        for (int num:ans){
            System.out.println(num);
        }
    }
}