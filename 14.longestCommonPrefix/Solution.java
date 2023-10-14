public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int idx = 0;
        flag: while (true) {
            for (int i = 1; i < strs.length; i++) {
                if (idx < strs[i].length() && idx < strs[i - 1].length() && strs[i].charAt(idx) == strs[i - 1].charAt(idx)) continue;
                else break flag;
            }
            idx++;
        }
        return strs[0].substring(0, idx);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"});
        System.out.println(ans);
    }
}