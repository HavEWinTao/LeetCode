public class Solution {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        return Integer.bitCount(temp);
    }
}
