public class Solution {
    public int partitionString(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        int ans = 0;
        int index = 0;
        boolean[] flag = new boolean[26];
        while (index < n) {
            if (flag[str[index] - 'a']) {
                flag = new boolean[26];
                ans++;
            }
            flag[str[index] - 'a'] = true;
            index++;
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abacaba";
        System.out.println(solution.partitionString(s));
    }
}