import java.util.HashSet;
import java.util.Set;

public class diagonalPrime {
    public int diagonalPrime(int[][] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i][i]);
            set.add(nums[i][n - i - 1]);
        }
        int[] array = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        for (int i = array.length - 1; i >= 0; i--) {
            if (isPrim(array[i])) {
                return array[i];
            }
        }
        return 0;
    }

    private boolean isPrim(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}