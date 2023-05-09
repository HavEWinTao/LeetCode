#include <iostream>
using namespace std;

class Solution {
public:
    string intToRoman(int num) {
        //M D C L X V I
        int base[7] = {1000, 500, 100, 50, 10, 5, 1};
        char base2char[7] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int coef[7] = {0};
        for (int i = 0; i < 7; i++) {
            coef[i] = num / base[i];
            num = num % base[i];
        }
        string ans;
        while (coef[0]--) {
            ans += base2char[0];//1000
        }
        if (coef[2] == 4) {
            if (coef[1] == 1) {
                ans += "CM";//900
            } else {
                ans += "CD";//400
            }
        } else {
            if (coef[1] == 1) {
                ans += "D";//500
            }
            while (coef[2]--) {
                ans += base2char[2];//100
            }
        }
        if (coef[4] == 4) {
            if (coef[3] == 1) {
                ans += "XC";//90
            } else {
                ans += "XL";//40
            }
        } else {
            if (coef[3] == 1) {
                ans += base2char[3];//50
            }
            while (coef[4]--) {
                ans += base2char[4];//10
            }
        }
        if (coef[6] == 4) {
            if (coef[5] == 1) {
                ans += "IX";//9
            } else {
                ans += "IV";//4
            }
        } else {
            if (coef[5] == 1) {
                ans += "V";//5
            }
            while (coef[6]--) {
                ans += base2char[6];//1
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    int num = 1994;
    string ans = solution.intToRoman(num);
    return 0;
}
