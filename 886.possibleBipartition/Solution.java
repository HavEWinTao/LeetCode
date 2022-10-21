public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int[] color = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int t = queue.poll();
                    for (int next : list.get(t)) {
                        if (color[next] > 0 && color[next] == color[t]) {
                            return false;
                        }
                        if (color[next] == 0) {
                            color[next] = 3 ^ color[t];
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}