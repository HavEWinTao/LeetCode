#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int searchInsert(vector<int> &nums, int target) {
        int left = 0;
        int right = (int) nums.size() - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < right) {
            return mid;
        } else {
            return left;
        }
    }
};

int main() {
    Solution solution;
    vector<int> nums = {1, 3, 5, 6};
    int ans = solution.searchInsert(nums, 2);
    return 0;
}
