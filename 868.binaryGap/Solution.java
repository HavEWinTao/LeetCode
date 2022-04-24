public class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        int index = 0;
        int last = -1;
        while (n != 0) {
            index++;
            int remain = n % 2;
            if (remain == 1) {
                if (last != -1) {
                    ans = Math.max(ans, index - last);
                }
                last = index;
            }
            n = n / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryGap(22));
    }
}
