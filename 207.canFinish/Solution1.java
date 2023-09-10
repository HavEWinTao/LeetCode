import java.util.*;

public class Solution {
    boolean[] cache;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            g.get(prerequisite[0]).add(prerequisite[1]);
        }
        cache = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean ret = dfs(g, new boolean[numCourses], i);
            if (!ret) return false;
            cache[i] = true;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> g, boolean[] vis, int u) {
        if (cache[u]) return true;
        vis[u] = true;
        for (int v : g.get(u)) {
            if (vis[v]) return false;
            boolean ret = dfs(g, vis, v);
            if (!ret) return false;
        }
        vis[u] = false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int numCourses = 2;
            int[][] prerequisites = {{1, 0}, {0, 1}};
            boolean ret = solution.canFinish(numCourses, prerequisites);
            System.out.println(ret);
        }
    }
}