import java.util.Random;

//1.拒绝采样，按正方形做，不在圆内重新采样
//2.分布函数
public class Solution {
    private final double radius;
    private final double x_center;
    private final double y_center;
    private final Random random;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double dis = Math.sqrt(random.nextDouble(radius * radius));
        double angle = random.nextDouble(2 * Math.PI);
        double x = x_center + dis * Math.sin(angle);
        double y = y_center + dis * Math.cos(angle);
        return new double[]{x, y};
    }
}
