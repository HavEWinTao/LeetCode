#include <iostream>
#include <string>
#include <stack>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        stack<char> Stack;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
                Stack.push(s[i]);
            } else if (s[i] == ')') {
                if (!Stack.empty() && Stack.top() == '(') {
                    Stack.pop();
                } else {
                    return false;
                }
            } else if (s[i] == '}') {
                if (!Stack.empty() && Stack.top() == '{') {
                    Stack.pop();
                } else {
                    return false;
                }
            } else if (s[i] == ']') {
                if (!Stack.empty() && Stack.top() == '[') {
                    Stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (Stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
};

int main() {
    Solution solution;
    string s = "]";
    bool ans = solution.isValid(s);
    return 0;
}
