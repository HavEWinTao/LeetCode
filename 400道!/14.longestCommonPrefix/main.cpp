#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        string ans;
        int min_len = INT_MAX;
        for (auto &str: strs) {
            if (str.length() < min_len) {
                min_len = str.length();
            }
        }
        int prefix = 0;
        bool flag = true;
        for (int i = 0; i < min_len; i++) {
            char temp = strs[0][i];
            for (int j = 1; j < strs.size(); j++) {
                if (strs[j][i] != temp) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                prefix++;
            } else {
                break;
            }
        }
        return strs[0].substr(0, prefix);
    }
};

int main() {
    Solution solution;
    vector<string> strs;
    strs.emplace_back("flower");
    strs.emplace_back("flow");
    strs.emplace_back("flight");
    string ans = solution.longestCommonPrefix(strs);
    return 0;
}
