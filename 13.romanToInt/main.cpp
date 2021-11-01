#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int base[7] = {1000, 500, 100, 50, 10, 5, 1};
        char base2char[7] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int len = s.length();
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s[i] == base2char[6]) {
                ans += base[6];
            } else if (s[i] == base2char[5]) {
                if ((i >= 1) && (s[i - 1] == base2char[6])) {
                    ans += 4;
                    i--;
                } else {
                    ans += 5;
                }
            } else if (s[i] == base2char[4]) {
                if ((i >= 1) && (s[i - 1] == base2char[6])) {
                    ans += 9;
                    i--;
                } else {
                    ans += 10;
                }
            } else if (s[i] == base2char[3]) {
                if ((i >= 1) && (s[i - 1] == base2char[4])) {
                    ans += 40;
                    i--;
                } else {
                    ans += 50;
                }
            } else if (s[i] == base2char[2]) {
                if ((i >= 1) && (s[i - 1] == base2char[4])) {
                    ans += 90;
                    i--;
                } else {
                    ans += 100;
                }
            } else if (s[i] == base2char[1]) {
                if ((i >= 1) && (s[i - 1] == base2char[2])) {
                    ans += 400;
                    i--;
                } else {
                    ans += 500;
                }
            } else if (s[i] == base2char[0]) {
                if ((i >= 1) && (s[i - 1] == base2char[2])) {
                    ans += 900;
                    i--;
                } else {
                    ans += 1000;
                }
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    string s = "III";
    int ans = solution.romanToInt(s);
    return 0;
}
