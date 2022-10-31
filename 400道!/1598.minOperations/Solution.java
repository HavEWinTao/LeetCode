public class Solution {
    public int minOperations(String[] logs) {
        int index = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (index > 0) {
                    index--;
                }
            } else if (log.equals("./")) {
                continue;
            } else if (log.matches(".*/$")) {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(solution.minOperations(logs));
    }
}