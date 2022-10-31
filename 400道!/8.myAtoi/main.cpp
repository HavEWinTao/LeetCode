#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        long long ans = 0;
        int len = s.length();
        bool sign = true;//正数
        bool num_start = false;
        for (int i = 0; i < len; i++) {
            if (s[i] <= '9' && s[i] >= '0') {
                int temp = s[i] - '0';
                num_start = true;
                if (sign == 0) {
                    ans = ans * 10 - temp;
                } else {
                    ans = ans * 10 + temp;
                }
                if (ans > (long long) INT_MAX) {
                    ans = INT_MAX;
                    break;
                }
                if (ans < (long long) INT_MIN) {
                    ans = INT_MIN;
                    break;
                }
            } else {
                if (num_start) {
                    break;
                }
                if (s[i] == ' ') {
                    continue;
                } else if (s[i] == '+') {
                    sign = true;
                    num_start = true;
                } else if (s[i] == '-') {
                    sign = false;
                    num_start = true;
                } else if (s[i] < '0' || s[i] > '9') {
                    break;
                }
            }
        }
        return (int) ans;
    }
};

int main() {
    string str = "  +  413";
    Solution solution;
    int ans = solution.myAtoi(str);
    return 0;
}
