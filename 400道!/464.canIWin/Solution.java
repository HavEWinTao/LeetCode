public class Solution {
    int n, t;
    int[] f = new int[1 << 20];

    //定义 f[state]f[state] 为当前状态为statestate，「当前先手」能否获胜（11 代表能，-1−1 代表不能）。
    // 1 true / -1 false
    int dfs(int state, int tot) {
        if (f[state] != 0) return f[state];
        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) continue;
            if (tot + i + 1 >= t) return f[state] = 1;
            if (dfs(state | (1 << i), tot + i + 1) == -1) return f[state] = 1;
        }
        return f[state] = -1;
    }

    public boolean canIWin(int _n, int _t) {
        n = _n;
        t = _t;
        if (n * (n + 1) / 2 < t) return false;
        if (t == 0) return true;
        return dfs(0, 0) == 1;
    }
}
