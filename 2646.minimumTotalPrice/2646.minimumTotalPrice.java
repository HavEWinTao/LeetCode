import java.util.*;

public class minimumTotalPrice {
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        int[][] prices = new int[n][n];//选第i个结点进行价格减半，第j个结点的价格
        for (int i = 0; i < n; i++) {
            prices[i] = price.clone();
        }
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        for (int i = 0; i < n; i++) {//第i个结点必选
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            boolean[] visit = new boolean[n];
            boolean flag = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int node = queue.poll();
                    visit[node] = true;
                    if (flag) prices[i][node] /= 2;
                    for (int v : g.get(node)) {
                        if (!visit[v]) queue.add(v);
                    }
                }
                flag = !flag;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            loop:
            for (int[] trip : trips) {
                Queue<Integer[]> queue = new ArrayDeque<>();//结点+花费
                queue.add(new Integer[]{trip[0], prices[i][trip[0]]});
                boolean[] visit = new boolean[n];
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        Integer[] node = queue.poll();
                        if (node[0] == trip[1]) {
                            temp += node[1];
                            continue loop;
                        }
                        visit[node[0]] = true;
                        for (int v : g.get(node[0])) {
                            if (!visit[v]) queue.add(new Integer[]{v, node[1] + prices[i][v]});
                        }
                    }
                }

            }
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        minimumTotalPrice solution = new minimumTotalPrice();
        int n = 9;
        int[][] edges = new int[][]{{2, 5}, {3, 4}, {4, 1}, {1, 7}, {6, 7}, {7, 0}, {0, 5}, {5, 8}};
        int[] price = new int[]{4, 4, 6, 4, 2, 4, 2, 14, 8};
        int[][] trips = new int[][]{{1, 5}, {2, 7}, {4, 3}, {1, 8}, {2, 8}, {4, 3}, {1, 5}, {1, 4}, {2, 1}, {6, 0}, {0, 7}, {8, 6}, {4, 0}, {7, 5}, {7, 5}, {6, 0}, {5, 1}, {1, 1}, {7, 5}, {1, 7}, {8, 7}, {2, 3}, {4, 1}, {3, 5}, {2, 5}, {3, 7}, {0, 1}, {5, 8}, {5, 3}, {5, 2}};
        System.out.println(solution.minimumTotalPrice(n, edges, price, trips));
    }
}
