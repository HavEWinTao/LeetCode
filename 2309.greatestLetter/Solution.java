class Solution {
    public String greatestLetter(String s) {
        boolean[][] flag = new boolean[26][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                flag[c - 'a'][0] = true;
            }
            if (c >= 'A' && c <= 'Z') {
                flag[c - 'A'][1] = true;
            }
        }
        String ans = "";
        for (int i = 0; i < 26; i++) {
            if (flag[i][0] && flag[i][1]) {
                ans = String.valueOf((char) ('A' + i));
            }
        }
        return ans;
    }
}