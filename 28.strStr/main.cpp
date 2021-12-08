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
    string haystack = "";
    string needle = "a";
    int ans = solution.strStr(haystack, needle);
    return 0;
}
