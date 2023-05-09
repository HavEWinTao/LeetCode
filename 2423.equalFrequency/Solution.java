public class Solution {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        int n = word.length();
        char[] str = word.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt[str[i] - 'a']++;
        }
        Arrays.sort(cnt);
        int[] cnt1 = cnt.clone();
        cnt1[25]--;
        Arrays.sort(cnt1);
        int index = 0;
        while (cnt1[index] == 0) {
            index++;
        }
        int fre1 = cnt1[index];
        boolean flag1 = true;
        while (index < 26) {
            if (fre1 != cnt1[index]) {
                flag1 = false;
                break;
            }
            index++;
        }
        int[] cnt2 = cnt.clone();
        Arrays.sort(cnt2);
        index = 0;
        while (cnt2[index] == 0) {
            index++;
        }
        cnt2[index]--;
        if (cnt2[index] == 0) {
            index++;
        }
        int fre2 = cnt2[index];
        boolean flag2 = true;
        while (index < 26) {
            if (fre2 != cnt2[index]) {
                flag2 = false;
                break;
            }
            index++;
        }
        return flag1 || flag2;
    }
}