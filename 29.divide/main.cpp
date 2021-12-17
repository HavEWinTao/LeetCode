#define get_bit(x, y)   ((x)>>(y) & 1)
#define N_MAX 32//最大支持32，可修改位32位以下的数

using namespace std;

class Solution {
public:
    //
    unsigned int add_overflow(unsigned int a, unsigned int b) {
        unsigned int c = 0;
        for (int i = 0; i < N_MAX; i++) {
            unsigned int bit_a = get_bit(a, i);
            unsigned int bit_b = get_bit(b, i);
            c = (c + bit_a + bit_b) % 2;
        }
        return c;
    }

    int bit_devide(unsigned int dividend, unsigned int divisor) {
        unsigned int sign1 = dividend >> (N_MAX - 1);//被除数符号
        unsigned int sign2 = divisor >> (N_MAX - 1);//除数符号
        sign1 = (sign1 << 1) | sign1;//两位表示
        sign2 = (sign2 << 1) | sign2;
        unsigned int sign = sign1 ^ sign2;//异或：同0异1
        unsigned int opp = 0xffffffff ^ (divisor - 1);//被除数的相反数
        unsigned int opp_sign = (~sign2) & 0x00000003;//被除数相反数的符号
        unsigned int ans = 0;
        unsigned int ans_sign = 0;
        if (sign == 0x00000003) {//被除数、除数异号
            dividend = dividend + divisor;//不会溢出
        } else {
            dividend = dividend + opp;
            if (add_overflow(dividend, opp)) {
                sign1 = sign1 + 1;
            }
        }
        for (int i = 0; i < N_MAX; i++) {
            if (sign1 == sign2) {//余数和divisor同号
                ans = ans | 0x00000001; //商1
                unsigned int bit_dividend = get_bit(dividend, (N_MAX - 1));
                sign1 = sign1 + bit_dividend;
                dividend = dividend << 1;//左移一位
                ans_sign = get_bit(ans, (N_MAX - 1));
                ans = ans << 1;
                dividend = dividend + opp;
                if (add_overflow(dividend, opp)) {
                    sign1 = sign1 + 1;
                    sign1 = sign1 & 0x00000003;
                }
            }
            if (sign1 != sign2) {//余数和divisor异号
                ans = ans & 0xfffffffe; //商0
                unsigned int bit_dividend = get_bit(dividend, (N_MAX - 1));
                sign1 = sign1 + bit_dividend;
                dividend = dividend << 1;//左移一位
                ans_sign = get_bit(ans, (N_MAX - 1));
                ans = ans << 1;
                dividend = dividend + divisor;
                if (add_overflow(dividend, divisor)) {
                    sign1 = sign1 + 1;
                    sign1 = sign1 & 0x00000003;
                }
            }
        }
        ans = ans | 0x00000001;

        int quotient = ans;
        if (ans_sign == 1) {//负数
            quotient = quotient * (-1);
        }
        return quotient;
    }

    int divide(int dividend, int divisor) {
        unsigned int num1 = dividend;//unsigned int的范围0~2^32
        unsigned int num2 = divisor;
        int ans = bit_devide(num1, num2);
        return ans;
    }
};

int main() {
    Solution solution;
    int dividend = 10;
    int divisor = 4;//int的范围-2^31~2^31-1
    int ans = solution.divide(dividend, divisor);
    return 0;
}
