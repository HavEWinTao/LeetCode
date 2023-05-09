public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        char a = '#', b = '#';
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if (a == '#') {
                    a = s1.charAt(i);
                    b = s2.charAt(i);
                } else {
                    if (cnt > 2) {
                        return false;
                    }
                    if (a != s2.charAt(i) || b != s1.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return cnt == 2 || cnt == 0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s1 = "aa";
        String s2 = "ac";
        System.out.println(solution.areAlmostEqual(s1,s2));
    }
}