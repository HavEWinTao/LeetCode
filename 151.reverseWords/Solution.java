public class Solution {
    public String reverseWords(String _s) {
        char[] s = _s.toCharArray();
        int n = s.length;
        int i = 0;
        int j = i;
        while (s[n - 1] == ' ') n--;
        while (i < n && j < n) {
            while (j < n && s[j] == ' ') j++;
            while (j < n && s[j] != ' ') s[i++] = s[j++];
            if (i < n) s[i] = ' ';
            i++;
        }
        n = i - 1;
        reverse(s, 0, n - 1);
        i = 0;
        while (i < n) {
            j = i;
            while (j < n && s[j] != ' ') j++;
            reverse(s, i, j - 1);
            i = j + 1;
        }
        return String.copyValueOf(s, 0, n);
    }

    public void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();
        {
            String s = "a good   example";
            String ret = solution.reverseWords(s);
            System.out.println(ret);
        }
        {
            String s = "  hello world  ";
            String ret = solution.reverseWords(s);
            System.out.println(ret);
        }
        {
            String s = "the sky is blue";
            String ret = solution.reverseWords(s);
            System.out.println(ret);
        }
    }
}