import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> a = new java.util.ArrayList<>(Arrays.stream(asteroids).boxed().toList());
        do {
            boolean flag = false;
            for (int i = 0; i < a.size() - 1; i++) {
                int a1 = a.get(i);
                int a2 = a.get(i + 1);
                if (a1 > 0 && a2 < 0) {
                    if (Math.abs(a1) < Math.abs(a2)) {
                        a.remove(i);
                    } else if (Math.abs(a1) > Math.abs(a2)) {
                        a.remove(i + 1);
                    } else {
                        a.remove(i + 1);
                        a.remove(i);
                    }
                    i--;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        } while (true);
        return a.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = new int[]{1, -1, -2, -2};
        System.out.println(Arrays.toString(solution.asteroidCollision(asteroids)));
    }
}
