public class Solution {
    public String interpret(String command) {
        int i = 0;
        int n = command.length();
        char[] str = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            if (str[i] == 'G') {
                sb.append('G');
            } else if (str[i] == ')') {
                sb.append('o');
            } else if (str[i] == 'a') {
                sb.append("al");
                i += 2;
            }
            i++;
        }
        return sb.toString();
    }
}