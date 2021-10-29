#include <iostream>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int temp[11] = {0};
            int index = 0;
            while (x) {
                temp[index++] = x % 10;
                x = x / 10;
            }
            int i = 0, j = index - 1;
            while (i < j) {
                if (temp[i] != temp[j]) {
                    return false;
                }
                i++, j--;
            }
        }
        return true;
    }
};

int main() {
    Solution solution;
    int input = 12;
    bool ans = solution.isPalindrome(input);
    return 0;
}
