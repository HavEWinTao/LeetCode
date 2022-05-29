package deleteText;

public class Solution {
    public String deleteText(String article, int index) {
        if (article.charAt(index) == ' ') {
            return article;
        }

        String[] text = article.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < text.length; i++) {
            String str = text[i];
            if (index >= idx && index < idx + str.length()) {
                idx += str.length();
            } else {
                idx += (str.length() + 1);
                stringBuilder.append(str);
                if (i != text.length - 1) {
                    stringBuilder.append(" ");
                }
            }

        }
        return stringBuilder.toString().strip();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String article = "e RSg c R cf";
        System.out.println(solution.deleteText(article, 10));
    }
}
