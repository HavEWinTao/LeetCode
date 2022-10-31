import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> edges;

    //拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] visited = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            //想学习prerequisite[0]，必须完成先修课prerequisite[1]
            edges.get(prerequisite[1]).add(prerequisite[0]);//建立先修课到课的边
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!DFS(i, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean DFS(int u, int[] visited) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                if (!DFS(v, visited)) {
                    return false;
                }
            } else if (visited[v] == 1) {
                return false;
            }
        }
        visited[u] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{0, 1}};

        Solution solution = new Solution();
        System.out.println(solution.canFinish(2, data));
    }
}
