public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] cnt = new int[26];
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 != l2) {
            return false;
        }
        for (int i = 0; i < l1; i++) {
            cnt[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < l2; i++) {
            cnt[s2.charAt(i) - 'a']--;
        }
        return Arrays.stream(cnt).allMatch(num -> num == 0);
    }
}