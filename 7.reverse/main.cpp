#include <iostream>
using namespace std;

class Solution {
public:
    int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans < INT_MIN / 10 || ans > INT_MAX / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            ans = ans * 10 + digit;
        }
        return ans;
    }
};

int main() {
    Solution solution;
    int ans = solution.reverse(-235);
    return 0;
}