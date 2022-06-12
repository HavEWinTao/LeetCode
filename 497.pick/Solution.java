import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution {

    private final List<Integer> areas;

    private int sum = 0;

    private final Random r;

    private final int[][] _rects;

    public Solution(int[][] rects) {
        r = new Random();
        areas = new ArrayList<>();
        areas.add(0);
        for (int[] rect : rects) {
            //包含边界的点
            int area = (rect[3] - rect[1] + 1) * (rect[2] - rect[0] + 1);
            sum += area;
            areas.add(sum);
        }
        _rects = rects;
    }

    public int[] pick() {
        int rand = r.nextInt(sum);
        int index = binarySearch(rand + 1) - 1;
        rand -= areas.get(index);//截取一个小长方形
        int col = _rects[index][3] - _rects[index][1] + 1;
        int dx = rand / col;
        int dy = rand - col * dx;
        return new int[]{_rects[index][0] + dx, _rects[index][1] + dy};
    }

    private int binarySearch(int target) {
        int left = 0, right = areas.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > areas.get(mid)) {
                left = mid + 1;
            } else if (target < areas.get(mid)) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] rects = new int[][]{//
                // {-2, -2, 1, 1}, {2, 2, 4, 6}
                {35330199, -46858448, 35330694, -46856950}};
        Solution solution = new Solution(rects);
        while (true) {
            System.out.println(Arrays.toString(solution.pick()));
        }
    }
}
