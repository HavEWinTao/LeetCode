#include <iostream>

using namespace std;

class Solution {
public:
    int bit_devide(int dividend, int divisor) {
        int ans = 0;
        int shift = 0;
        int temp = divisor;
        int bound = INT_MIN >> 1;
        while (dividend < temp && bound <= temp) {
            shift++;
            temp = (unsigned int) temp << 1;
        }
        while (shift > -1) {
            if (dividend <= (int) (((unsigned int) divisor) << shift)) {
                dividend -= (unsigned int) divisor << shift;
                ans += (1 << shift);
            }
            shift--;
        }
        return ans;
    }

    int divide(int dividend, int divisor) {
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        }
        if (dividend == 0 || divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        if (dividend == divisor) {
            return 1;
        }
        int sign = (dividend > 0) ^ (divisor > 0);//异或：同0异1
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int ans = bit_devide(dividend, divisor);
        if (sign) {
            return -ans;
        } else {
            return ans;
        }
    }
};

int main() {
    Solution solution;
    int dividend = -2147483648;
    //dividend = 10;
    int divisor = 2;//int的范围-2^31~2^31-1
    int ans = solution.divide(dividend, divisor);
    printf("%d", ans);
    return 0;
}
