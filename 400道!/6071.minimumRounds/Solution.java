import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> taskNum = new HashMap<>();
        for (int task : tasks) {
            int num = taskNum.getOrDefault(task, 0);
            taskNum.put(task, num + 1);
        }
        int ans = 0;
        for (int key : taskNum.keySet()) {
            int num = taskNum.get(key);
            int cnt = num / 3;
            if (num % 3 == 2) {
                cnt++;
            } else if (num % 3 == 1) {
                if (cnt == 0) {
                    return -1;
                } else {
                    cnt++;
                }
            }
            ans += cnt;
        }
        return ans;
    }
}
