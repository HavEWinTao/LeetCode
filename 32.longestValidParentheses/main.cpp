#include <iostream>
#include <string>
#include <stack>

using namespace std;

class Solution {
public:
    int longestValidParentheses(string s) {
        //左面有)不匹配，右面多)
        //发生错误从头再来
        stack<int> sta;
        sta.push(-1);
        int ans = 0;
        int size = s.size();
        for (int i = 0; i < size; i++) {
            if (s[i] == '(') {
                sta.push(i);
            } else {
                sta.pop();
                if (sta.empty()) {
                    sta.push(i);
                } else {
                    ans = max(ans, i - sta.top());
                }
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    string s = ")()())";
    int ans = solution.longestValidParentheses(s);
    return 0;
}
