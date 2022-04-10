package lightSticks;

import java.util.*;

//点燃木棒——超内存了
public class Solution {
    private int points;

    public int[] lightSticks(int height, int width, int[] indices) {
        points = (height + 1) * (width + 1);
        //保存图点-->点间有边
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for (int i = 0; i < points; i++) {
            edges.put(i, new HashSet<>());
        }
        //除去的边
        Set<Integer> except = new HashSet<>();
        for (int num : indices) {
            except.add(num);
        }
        //保存边
        Set<Integer> stick = new HashSet<>();
        //两点到边的映射
        Map<Integer, Integer> points2edge = new HashMap<>();

        for (int i = 0; i <= height; i++) {
            for (int j = 0; j < width; j++) {
                int heng = i * ((width + 1) + width) + j;
                //System.out.println("" + i + " " + j + " " + heng);
                if (!except.contains(heng)) {
                    stick.add(heng);
                    int point1 = i * (width + 1) + j;
                    int point2 = point1 + 1;
                    //System.out.println("point1" + point1 + " point2" + point2);
                    edges.get(point1).add(point2);
                    edges.get(point2).add(point1);
                    points2edge.put(point1 * points + point2, heng);
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= width; j++) {
                int shu = (i + 1) * width + i * (width + 1) + j;
                //System.out.println("" + i + " " + j + " " + shu);
                if (!except.contains(shu)) {
                    stick.add(shu);
                    int point1 = i * (width + 1) + j;
                    int point2 = point1 + width + 1;
                    //System.out.println("point1" + point1 + " point2" + point2);
                    edges.get(point1).add(point2);
                    edges.get(point2).add(point1);
                    points2edge.put(point1 * points + point2, shu);
                }
            }
        }

        boolean flag = judge(edges, stick, points2edge);
        if (!flag) {
            return new int[]{};
        }

        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                int point = i * (width + 1) + j;
                boolean[] visit = new boolean[points];
                int temp = BFS(point, edges, visit);
                if (temp < min) {
                    min = temp;
                    ans.clear();
                    ans.add(point);
                } else if (temp == min) {
                    ans.add(point);
                }
            }
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }

    private boolean judge(Map<Integer, Set<Integer>> edges, Set<Integer> stick, Map<Integer, Integer> points2edge) {
        int[] visit = new int[edges.size()];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visit[0] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            Set<Integer> e = edges.get(temp);
            for (Integer t : e) {
                if (visit[t] != 2) {
                    Integer key = Math.min(t, temp) * points + Math.max(t, temp);
                    int edge = points2edge.get(key);
                    stick.remove(edge);
                    visit[t] = 1;
                    queue.add(t);
                }
            }
            visit[temp] = 2;
        }
        return stick.isEmpty();
    }

    private int BFS(int point, Map<Integer, Set<Integer>> edges, boolean[] visit) {
        Set<Integer> isValid = edges.get(point);
        if (isValid.size() == 0) {
            return Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(point);
        visit[point] = true;
        int time = 0;
        while (!queue.isEmpty()) {
            time += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                Set<Integer> e = edges.get(temp);
                for (Integer t : e) {
                    if (!visit[t]) {
                        visit[t] = true;
                        queue.add(t);
                    }
                }
            }
        }
        return time - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] indices = new int[]{0, 3};
        System.out.println(Arrays.toString(solution.lightSticks(1, 1, indices)));
    }
}
