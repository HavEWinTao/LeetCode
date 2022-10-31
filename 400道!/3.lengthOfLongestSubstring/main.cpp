#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int ans = 0;
        int alphabet[256] = {0};
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s[i];
            //字母还未出现过，字母在left的左侧
            if (alphabet[index] == 0 || alphabet[index] < left) {
                ans = max(ans, i - left + 1);
            } else {//字母在当前窗口内
                left = alphabet[index];
            }
            alphabet[index] = i + 1;
        }
        return ans;
    }
};

int main() {
    string s = "abcabcbb";
    Solution solution;
    int ans = solution.lengthOfLongestSubstring(s);
    return 0;
}
