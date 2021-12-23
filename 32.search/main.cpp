#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int> &nums, int target) {
        int ans = -1;
        int size = (int) nums.size();
        int right = size;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {//第一段升序区间里
                if (target > nums[mid]) {//右面有两个升序序列，但是分开了两部分，第二部分比较小
                    left = mid + 1;
                } else if (target == nums[mid]) {//找到
                    ans = mid;
                    break;
                } else {//在左区间内查找或者在第二个区间内查找
                    right = mid - 1;
                }
            } else {//mid已经在第二个区间了
                if (target > nums[mid] && target < nums[size - 1]) {//在第二个区间内
                    left = mid + 1;
                } else if (target > nums[mid] && target > nums[size - 1]) {//第一个区间内
                    right = mid - 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    ans = mid;
                }
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    vector<int> nums{4, 5, 6, 7, 0, 1, 2};
    int ans = solution.search(nums, 0);
    return 0;
}
