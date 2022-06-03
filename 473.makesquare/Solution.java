import java.util.Arrays;

public class Solution {
    private int length;

    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        length = sum / 4;
        Arrays.sort(matchsticks);
        return dfs(matchsticks, matchsticks.length - 1, new int[4]);
    }

    boolean dfs(int[] matchsticks, int idx, int[] cur) {
        if (idx == -1) {
            return true;
        }
        //才发现java的for循环的continue还有这种用法
        out:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                if (cur[j] == cur[i]) continue out;
            }
            int u = matchsticks[idx];
            if (cur[i] + u > length) {
                continue;
            }
            cur[i] += u;
            if (dfs(matchsticks, idx - 1, cur)) {
                return true;
            }
            cur[i] -= u;
        }
        return false;
    }
}
