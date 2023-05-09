import java.util.*;

public class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrictNode = new HashSet<>();
        for (int restrict : restricted) {
            restrictNode.add(restrict);
        }
        int ans = 1;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visit[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                List<Integer> children = tree.get(node);
                for (int child : children) {
                    if (!restrictNode.contains(child)) {
                        if (!visit[child]) {
                            queue.add(child);
                            ans++;
                            visit[child] = true;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
        int[] restricted = new int[]{4, 2, 1};
        System.out.println(solution.reachableNodes(n, edges, restricted));
    }
}
