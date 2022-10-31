import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<Point> points = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {
            int[] circle = circles[i];
            int left = circle[0] - circle[2];
            int right = circle[0] + circle[2];
            int up = circle[1] + circle[2];
            int down = circle[1] - circle[2];
            for (int j = left; j <= right; j++) {
                for (int k = down; k <= up; k++) {
                    double dis = calDis(j, k, circle[0], circle[1]);
                    if (dis <= circle[2]) {
                        Point point = new Point(j, k);
                        points.add(point);
                    }
                }
            }
        }
        return points.size();
    }

    private double calDis(int x, int y, int i, int j) {
        return Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
    }

    public static void main(String[] args) {
        int[][] circles = new int[][]{
                {2, 2, 2}, {2, 2, 1}
        };
        Solution solution = new Solution();
        System.out.println(solution.countLatticePoints(circles));
    }
}

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int hashCode() {
        return this.x * 1000 + y;
    }
}
