public class Solution {
    //由于 AND 不会让数字变大，那么最大值就是数组的最大值
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == max) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }
        return ans;
    }
}