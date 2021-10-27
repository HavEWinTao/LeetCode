#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int group = 2 * numRows - 2;
        int length = s.length();
        string ans;
        for (int i = 0; i < numRows; i++) {
            int temp = i;
            bool flag = true;
            while (temp < length) {
                ans += s[temp];
                if (i == 0 || i == numRows - 1) {
                    temp += group;
                } else {
                    if (flag) {
                        temp = temp + 2 * (numRows - i - 1);
                        flag = false;
                    } else {
                        temp = temp + (i * 2);
                        flag = true;
                    }
                }
            }
        }
        return ans;
    }
};

int main() {
    string str = "A";
    int len = str.length();
    Solution solution;
    string ans = solution.convert(str,1);
    return 0;
}
