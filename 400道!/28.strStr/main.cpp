#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    void getNext(string needle, vector<int> &next) {
        int m = needle.size();
        next[0] = -1;
        int i = 0, j = -1;
        while (i < m) {
            if (j == -1 || needle[i] == needle[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else
                j = next[j];
        }
    }

    int strStr(string haystack, string needle) {
        int m = haystack.size();
        int n = needle.size();
        vector<int> next(50001);
        getNext(needle, next);
        int i = 0, j = 0;
        while (i < m && j < n) {
            //j变成-1就是匹配失败，继续匹配
            //所以j++变成0从needle的第0个开始判断，i++从haystack的下一个字母开始判断
            if (j == -1 || haystack[i] == needle[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == n) {
            return i - j;
        } else {
            return -1;
        }
    }
};

int main() {
    Solution solution;
    string haystack = "hello";
    string needle = "ll";
    int ans = solution.strStr(haystack, needle);
    return 0;
}
