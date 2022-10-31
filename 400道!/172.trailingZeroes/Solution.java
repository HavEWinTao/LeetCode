public class Solution {
    //遍历找2和5-->遍历找5-->除5找5
    public int trailingZeroes(int n) {
        int num5 = 0;
        //int num2 = 0;
        /*
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while ((temp != 0) && (temp % 5 == 0)) {
                num5++;
                temp = temp / 5;
            }
            //while ((temp != 0) && (temp % 2 == 0)) {
            //    num2++;
            //    temp = temp / 2;
            //}
        }
         */
        while (n != 0) {
            n = n / 5;
            num5 += n;
        }
        return num5;
        //return Math.min(num2, num5);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(5));
    }
}
