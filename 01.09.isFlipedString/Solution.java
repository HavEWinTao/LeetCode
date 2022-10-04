public class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s3 = s2 + s2;
        return s3.contains(s1);
    }
}