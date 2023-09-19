import java.util.*;

public class Solution {
    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder());
        return ans;
    }

    private void dfs(int n, int open, int close, StringBuilder sb) {
        if (open == n && close == n) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            dfs(n, open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            dfs(n, open, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        {
            List<String> ans = solution.generateParenthesis(3);
            System.out.println(ans);
        }
    }
}