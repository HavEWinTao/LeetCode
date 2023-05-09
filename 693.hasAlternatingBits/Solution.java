public class Solution {
    public boolean hasAlternatingBits(int n) {
        int base = n % 2;
        n = n / 2;
        while (n != 0) {
            if (base == n % 2) {
                return false;
            }
            base = n % 2;
            n = n / 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(11));
    }
}
