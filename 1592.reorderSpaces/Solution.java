import java.util.*;

public class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int n = words.length;
        //System.out.println(n);
        //for (String word:words){
        //    System.out.println(word);
        //}
        int blank = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                blank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            sb.append(words[0]);
            for (int i = 0; i < blank; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int num1 = blank / (n - 1);
        int num2 = blank % (n - 1);
        System.out.println(num2);

        for (int i = 0; i < n; i++) {
            sb.append(words[i]);
            if (i != n - 1) {
                for (int j = 0; j < num1; j++) {
                    sb.append(' ');
                }
            }
        }
        for (int i = 0; i < num2; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text = "  this";
        System.out.println(solution.reorderSpaces(text));
    }
}