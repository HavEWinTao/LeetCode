public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] arr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            arr[i][0] = arr[i][1] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (arr[c - 'a'][0] == -1) {
                arr[c - 'a'][0] = i;
            } else {
                arr[c - 'a'][1] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i][0] != -1 && arr[i][1] != -1) {
                ans = Math.max(ans, arr[i][1] - arr[i][0]);
            }
        }
        return ans - 1;
    }
}