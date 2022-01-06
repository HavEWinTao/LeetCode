#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int firstMissingPositive(vector<int> &nums) {
        int size = (int) nums.size();
        int ans = INT32_MAX;
        for (int i = 0; i < size; i++) {
            if (nums[i] < ans) {
                ans = nums[i];
            }
        }
        if ()
    }
};

int main() {
    Solution solution;
    vector<int> nums{1, 2, 0};
    int ans = solution.firstMissingPositive(nums);
    return 0;
}
