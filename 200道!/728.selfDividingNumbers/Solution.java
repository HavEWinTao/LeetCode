import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDividing(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isDividing(int num) {
        int temp = num;
        while (temp > 0) {
            int item = temp % 10;
            if (item == 0 || num % item != 0) {
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> ans = solution.selfDividingNumbers(1, 22);
        System.out.println(ans);
    }
}
