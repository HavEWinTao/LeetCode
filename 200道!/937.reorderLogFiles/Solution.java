import java.util.*;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> log1 = new ArrayList<>();
        List<String> log2 = new ArrayList<>();
        for (String log : logs) {
            String[] splits = log.split(" ");
            char c = splits[1].charAt(0);
            if (c >= '0' && c <= '9') {
                log1.add(log);
            }
            if (c >= 'a' && c <= 'z') {
                log2.add(log);
            }
        }
        log2.sort((o1, o2) -> {
            int index1 = o1.indexOf(" ");
            int index2 = o2.indexOf(" ");
            int flag = o1.substring(index1).compareTo(o2.substring(index2));
            if (flag == 0) {
                return o1.substring(0, index1).compareTo(o2.substring(0, index2));
            } else {
                return flag;
            }
        });
        log2.addAll(log1);
        return log2.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] logs = new String[]{
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };
        System.out.println(Arrays.toString(solution.reorderLogFiles(logs)));
    }
}
