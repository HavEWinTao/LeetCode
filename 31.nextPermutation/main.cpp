#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
class Solution {
public:
    void nextPermutation(vector<int> &nums) {
        int size = nums.size();
        int index1 = -1, index2;
        for (int i = size - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index1 = i - 1;
                break;
            }
        }
        if (index1 != -1) {
            for (int i = size - 1; i > index1; i--) {
                if (nums[i] > nums[index1]) {
                    index2 = i;
                    break;
                }
            }
            swap(nums[index1], nums[index2]);
        }
        sort(nums.begin() + (index1 + 1), nums.end());
    }
};

int main() {
    Solution solution;
    //vector<int> nums{1, 5, 8, 4, 7, 6, 5, 3, 1};
    vector<int> nums{3, 2, 1};
    solution.nextPermutation(nums);
    return 0;
}
