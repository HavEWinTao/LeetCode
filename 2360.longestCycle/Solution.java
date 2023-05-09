import java.util.HashMap;
import java.util.Map;

public class Solution {

    boolean[] visit;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        visit = new boolean[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int circle = calCircle(edges, i);
                ans = Math.max(ans, circle);
            }
        }
        return ans;
    }

    private int calCircle(int[] edges, int node) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        while (node != -1) {
            if (map.containsKey(node)) {
                int ret = 1;
                int temp = node;
                while (edges[node] != temp) {
                    node = edges[node];
                    ret++;
                }
                return ret;
            }
            if (visit[node]) {
                return -1;
            }
            map.put(node, length);
            visit[node] = true;
            node = edges[node];
            length += 1;
        }
        return -1;
    }
}
