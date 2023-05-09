#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    void backtrack(vector<string> &ans, string &cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
            ans.push_back(cur);
            return;
        }
        if (open < n) {
            cur.push_back('(');
            backtrack(ans, cur, open + 1, close, n);
            cur.pop_back();
        }
        if (close < open) {
            cur.push_back(')');
            backtrack(ans, cur, open, close + 1, n);
            cur.pop_back();
        }
    }

    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string cur;
        backtrack(ans, cur, 0, 0, n);
        return ans;
    }
};

int main() {
    Solution solution;
    vector<string> ans = solution.generateParenthesis(3);
    return 0;
}
