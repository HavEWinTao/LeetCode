public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tCnt = 0;
        int fCnt = 0;
        int ans = 0;
        int left = 0;
        //[left right]内T和F的数量
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                tCnt++;
            } else {
                fCnt++;
            }
            //如果T,F数量中的最小值比k大了，说明以及无法修改了
            //将left右移
            while (Math.min(tCnt, fCnt) > k) {
                if (answerKey.charAt(left) == 'T') {
                    tCnt--;
                } else {
                    fCnt--;
                }
                left++;
            }
            //[left,right]这段区间可以修改为相同的
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String answerKey = "TTTTFF";
        System.out.println(solution.maxConsecutiveAnswers(answerKey, 2));
    }
}
