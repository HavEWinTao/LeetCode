public class Solution {
    public int countPrimeSetBits1(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int x) {
        if (x < 2) {//1不是质数
            return false;
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    //注意到right<10^6<2^20
    //因此二进制中1的个数不会超过19，而不超过19的质数只有
    //2, 3, 5, 7, 11, 13, 17, 19
    //我们可以用一个二进制数mask=665772=10100010100010101100
    //来存储这些质数，其中mask二进制的从低到高的第i位为1表示i是质数，为0表示i不是质数

    //设整数x的二进制中1的个数为c，若mask按位与2^c不为0，则说明c是一个质数

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (((1 << Integer.bitCount(i)) & 665772) != 0) {
                ans++;
            }
        }
        return ans;
    }
}
