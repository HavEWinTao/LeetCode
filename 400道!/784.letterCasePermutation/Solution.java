public class Solution {

    private List<String> ans = new ArrayList<>();

    private String s;

    private int n;

    public List<String> letterCasePermutation(String _s) {
        s = _s;
        n = s.length();
        DFS(new StringBuilder(), 0);
        return ans;
    }

    public void DFS(StringBuilder sb, int i) {
        if (i == n) {
            ans.add(sb.toString());
            return;
        }
        char c1 = s.charAt(i);
        DFS(new StringBuilder(sb.toString()).append(c1), i + 1);
        if (c1 > '9') {
            char c2 = (c1 >= 'a' && c1 <= 'z') ? (char) (c1 - 32) : (char) (c1 + 32);
            DFS(new StringBuilder(sb.toString()).append(c2), i + 1);
        }
    }
}