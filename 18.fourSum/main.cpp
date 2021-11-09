#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {

    }
};

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(0);
    nums.push_back(-1);
    nums.push_back(0);
    nums.push_back(-2);
    nums.push_back(2);
    vector<vector<int>> ans = solution.fourSum(nums,0);
    return 0;
}
