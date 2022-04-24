import java.util.*;

public class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> v = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            v.add(new ArrayList<>());
        }
        for (int[] rectangle : rectangles) {
            v.get(rectangle[1]).add(rectangle[0]);
        }
        for (int i = 0; i < 101; i++) {
            Collections.sort(v.get(i));
        }

        int n = points.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            for (int j = point[1]; j < 101; j++) {
                ans[i] += v.get(j).size() - lowerBound(v.get(j), point[0]);
            }
        }
        return ans;
    }

    private int lowerBound(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rectangles = new int[][]{
                {1, 2}, {2, 3}, {2, 5}
        };
        int[][] points = new int[][]{
                {2, 1}, {1, 4}
        };
        System.out.println(Arrays.toString(solution.countRectangles(rectangles, points)));
    }
}
