public class Solution {
    public String minWindow(String s, String t) {
        int[] tCharNums = new int[26];
        int cnt = s.length();
        for (int i=0;i<t.length();i++){
            tCharNums[t.charAt(i)-'0']++;
        }
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        return ans;
    }
}
