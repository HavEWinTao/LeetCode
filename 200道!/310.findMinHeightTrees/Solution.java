import java.util.*;

public class Solution {
    //最小高度就是找最长的路径，然后在中间截断开就是最小的高度，最大的高度应该是最长路径
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //edge case
        if (n == 1) {
            return new ArrayList<>(List.of(0));
        }
        //边集，无向边
        Map<Integer, Set<Integer>> adj = getAdj(edges);
        //每个点的入度
        int[] indegree = getIndegree(adj);

        //使用一个集合进行BFS，将所有的叶子节点放入到队列中
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        List<Integer> ans = null;
        while (!queue.isEmpty()) {//如果集合为空说明所有的节点都被移除了，而ans中保存的是上一轮的节点
            int size = queue.size();
            ans = new ArrayList<>(queue);
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();//把curr这个节点移除
                for (int next : adj.get(curr)) {
                    indegree[next]--;//所以合curr连接的节点的入度都应该--
                    if (indegree[next] == 1) {//当他度为1时他就成了叶子节点
                        queue.offer(next);
                    }
                }
            }
        }
        return ans;//ans的size可能是1可能是2
    }

    private Map<Integer, Set<Integer>> getAdj(int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new HashSet<>());
            adj.get(edge[0]).add(edge[1]);

            adj.putIfAbsent(edge[1], new HashSet<>());
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    private int[] getIndegree(Map<Integer, Set<Integer>> adj) {
        int n = adj.keySet().size();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            indegree[i] = adj.get(i).size();//无向图中出度=入度
        }
        return indegree;
    }
}
