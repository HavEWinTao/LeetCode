public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        //0-9拿来特殊处理
        if (n == 1) {
            return 10;
        }
        n--;
        int cnt = 9;
        int ans = 9;
        int temp = 9;
        while (cnt > 0 && n > 0) {
            temp = cnt * temp;
            ans += temp;
            cnt--;
            n--;
        }
        return ans + 1;
    }

    public int countNumbersWithUniqueDigits1(int n) {
        int[] ans = new int[]{1, 10, 91, 739, 5275, 32491, 168571, 712891, 2345851};
        return ans[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 9; i++) {
            System.out.println(solution.countNumbersWithUniqueDigits(i));
        }
    }
}
