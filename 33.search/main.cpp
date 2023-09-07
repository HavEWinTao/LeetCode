#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int> &nums, int target) {
        int size = (int) nums.size();
        if (size == 0) {
            return -1;
        }
        if (size == 1) {
            return (nums[0] == target) ? 0 : -1;
        }
        int right = size - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {//mid在第一段升序区间
                if (nums[0] <= target && target <= nums[mid]) {//在0~mid区间内
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//mid在第二段升序区间
                if (nums[mid] <= target && target <= nums[size - 1]) {//在mid~size-1的区间内
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
};

int main() {
    Solution solution;
    vector<int> nums{1, 3};
    int ans = solution.search(nums, 0);
    return 0;
}
