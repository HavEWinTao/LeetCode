import java.util.*;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer[]> stack = new Stack<>();
        for (String log : logs) {
            String[] items = log.split(":");
            if (items[1].equals("start")) {
                int id = Integer.parseInt(items[0]);
                int startTime = Integer.parseInt(items[2]);

                if (!stack.isEmpty()) {
                    Integer[] info = stack.peek();
                    ans[info[0]] += (startTime - info[1]);

                }

                stack.add(new Integer[]{id, startTime});
            }
            if (items[1].equals("end")) {
                int endTime = Integer.parseInt(items[2]);
                Integer[] info1 = stack.pop();
                ans[info1[0]] += endTime - info1[1] + 1;
                if (!stack.isEmpty()) {
                    Integer[] info2 = stack.pop();
                    info2[1] = endTime + 1;
                    stack.add(info2);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 2;
        String[] temp = new String[]{"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        List<String> logs = new ArrayList<>();
        Collections.addAll(logs, temp);
        System.out.println(Arrays.toString(solution.exclusiveTime(n, logs)));
    }
}
