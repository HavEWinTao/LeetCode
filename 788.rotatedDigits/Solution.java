public class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        out:
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            int num = i;
            while (num != 0) {
                int temp = num % 10;
                num /= 10;
                //347
                if (temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                    flag = true;
                } else if (temp != 0 && temp != 1 && temp != 8) {
                    continue out;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        System.out.println(solution.rotatedDigits(10));
    }
}