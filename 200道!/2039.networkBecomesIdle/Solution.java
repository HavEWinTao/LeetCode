import java.util.*;

public class Solution {

    private int n;

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        n = patience.length;
        //计算0点到其他点的最短距离
        Map<Integer, Integer> node2Dis = calDis(edges);

        int ans = 0;
        for (int i = 1; i < patience.length; i++) {
            int dis = node2Dis.get(i);//距离
            int extra = (2 * dis - 1) / patience[i];//额外请求次数
            int time = 2 * dis + extra * patience[i];
            if (time > ans) {
                ans = time;
            }
        }
        return ans + 1;
    }

    public Map<Integer, Integer> calDis(int[][] edges) {
        Map<Integer, Integer> dis = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dis.put(i, 0);
        }


        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        Map<Integer, Set<Integer>> graph = getGraph(edges);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph.get(u)) {
                if (!visited.contains(v)) {
                    dis.put(v, dis.get(u) + 1);
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
        return dis;
    }

    public Map<Integer, Set<Integer>> getGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
