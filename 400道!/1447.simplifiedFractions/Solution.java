import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = n; i > 1; i--) {
            for (int j = i - 1; j >= 1; j--) {
                if (gcd(j, i) == 1) {
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    private int gcd(int i, int j) {
        if (j == 0) {
            return i;
        } else {
            return gcd(j, i % j);
        }
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifiedFractions(2));
    }
}
