package src;

import java.util.Arrays;

public class Solution1 {
    static int[] cnt = new int[100010], sum = new int[100010];

    //cnt数组记录每个数的出现次数（即cnt[i]=x含义为数值i的出现次数为x次）
    //sum来记录出现次数为某个值的数有多少个（即sum[i]=x含义为出现次数为i的数值共有x个）
    //max来记录最大出现次数cnt[i]
    public int maxEqualFreq(int[] nums) {
        Arrays.fill(cnt, 0);
        Arrays.fill(sum, 0);
        int n = nums.length, max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int cur = ++cnt[num];
            int len = i + 1;
            sum[cur]++;
            sum[cur - 1]--;
            max = Math.max(max, cur);
            if (max == 1) {
                ans = len;
            }
            if (max * sum[max] + 1 == len) {
                ans = len;
            }
            if ((max - 1) * (sum[max - 1] + 1) + 1 == len) {
                ans = len;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{2, 2, 1, 1, 5, 3, 3, 5};
        System.out.println(solution.maxEqualFreq(nums));
    }
}
