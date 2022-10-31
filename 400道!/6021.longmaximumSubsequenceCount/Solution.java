public class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        StringBuilder temp = new StringBuilder();
        char a = pattern.charAt(0);
        char b = pattern.charAt(1);

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == a) {
                temp.append(a);
            } else if (text.charAt(i) == b) {
                temp.append(b);
            }
        }
        String str = a + temp.toString() + b;
        int length = str.length() - 1;
        long ans1 = 0;
        long ans2 = 0;

        int cnt = 0;
        for (int i = 0; i < length; i++) {

            if (str.charAt(i) == b) {
                ans1 += cnt;
            }
            if (str.charAt(i) == a) {
                cnt++;
            }
        }
        cnt = 0;
        for (int i = 1; i <= length; i++) {

            if (str.charAt(i) == b) {
                ans2 += cnt;
            }
            if (str.charAt(i) == a) {
                cnt++;
            }
        }
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String text = "abdcdbc";
        String text = "fwymvreuftzgrcrxczjacqovduqaiig";
        //String pattern = "ac";
        String pattern = "yy";
        long ans = solution.maximumSubsequenceCount(text, pattern);
        System.out.println(ans);
    }
}
