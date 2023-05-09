import java.util.*;

class Solution {
    private final char[][] arr = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    private char[] digits;
    List<String> ans;

    public List<String> letterCombinations(String _digits) {
        digits = _digits.toCharArray();
        ans = new ArrayList<>();
        if (digits.length == 0) {
            return ans;
        }
        DFS(new StringBuffer(), 0);
        return ans;
    }

    private void DFS(StringBuffer sf, int depth) {
        if (depth == digits.length) {
            ans.add(sf.toString());
            return;
        }
        for (int i = 0; i < arr[digits[depth] - '0'].length; i++) {
            DFS(sf.append(arr[digits[depth] - '0'][i]), depth + 1);
            sf.deleteCharAt(depth);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        System.out.println(solution.letterCombinations(digits));
    }
}