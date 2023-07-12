class Solution {
    public long minimumCost(String S) {
        long ans = 0;
        char[] s = S.toCharArray();
        int n = s.length;
        for (int i = 1; i < n; i++)
            if (s[i - 1] != s[i])
                ans += Math.min(i, n - i);
        return ans;
    }
}