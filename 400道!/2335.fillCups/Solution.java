import java.util.Arrays;

public class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int a = amount[0];
        int b = amount[1];
        int c = amount[2];
        int ans = 0;
        while (a != 0) {
            a--;
            ans++;
            if (c > b) {
                c--;
            } else {
                b--;
            }
        }
        if (c > b) {
            ans += c;
        } else {
            ans += b;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] amount = new int[]{5,4,4};
        System.out.println(solution.fillCups(amount));
    }
}
