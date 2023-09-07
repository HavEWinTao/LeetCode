class Solution1 {
    public int lengthOfLongestSubstring(String _s) {
        char[] s = _s.toCharArray();
        Map<Character, Integer> idx = new HashMap<>();
        int ans = 0;
        int last = -1;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (!idx.containsKey(c)) {
                idx.put(c, i);
                ans = Math.max(ans, i - last);
            } else {
                for (int j = last + 1; j < idx.get(c); j++) {
                    idx.remove(s[j]);
                }
                ans = Math.max(ans, i - idx.get(c));
                last = idx.get(c);
                idx.put(c, i);
            }
        }
        return ans;
    }
}