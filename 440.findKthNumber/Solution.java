public class Solution {
    private int n;
    private int k;

    private int ans;
    private int id;

    public int findKthNumber(int n, int k) {
        this.n = n;
        this.k = k;
        solve(1);
        return ans;
    }

    public void solve(long base) {
        for (int i = 0; i <= 9; i++) {
            long temp = base + i;
            if (temp > n) {
                return;
            }
            id++;
            if (id == k) {
                ans = (int) temp;
                return;
            } else if (id < k) {
                solve(temp * 10);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(681692778, 351251360));
        //int ans = solution.findKthNumber(12345, 12345);
        //System.out.println(ans + "==>" + "12345");
        System.out.println(Integer.MAX_VALUE);
    }
}