public class Solution {
    //异或自身奇数次等于自身
    //A & （A-1）去掉最后一位1
    //A & 1 == 0 判断奇偶
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 1; i < n; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        return ans;
    }
}
