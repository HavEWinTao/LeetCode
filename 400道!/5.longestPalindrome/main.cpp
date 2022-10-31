#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.length();
        int dp[1010][1010] = {0};
        for (int i = 0; i < len - 1; i++) {
            dp[i][i] = 1;
            if (s[i] == s[i + 1]) {
                dp[i + 1][i] = 1;
            }
        }
        int left = 0, right = 0;
        int max_len = right - left + 1;
        dp[len - 1][len - 1] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s[j] == s[i]) {
                    int temp = i - j + 1;
                    dp[j][i] = dp[j + 1][i - 1];
                    if (dp[j][i] == 1 && temp > max_len) {
                        left = j, right = i;
                        max_len = temp;
                    }
                } else {
                    dp[j][i] = 0;
                }
            }
        }
        return s.substr(left, right - left + 1);
    }
};

int main() {
    string str = "aacabdkacaa";
    Solution solution;
    string ans = solution.longestPalindrome(str);
    return 0;
}
