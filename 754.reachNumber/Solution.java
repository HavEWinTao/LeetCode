public class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int i = 1;
        int sum = 0;
        while ((sum - target) % 2 == 1 || sum < target) {
            sum += i;
            i++;
        }
        return i - 1;
    }
}