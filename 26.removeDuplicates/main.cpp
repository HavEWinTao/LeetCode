#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int> &nums) {
        int length = nums.size();
        if (length == 0) {
            return 0;
        }
        int cnt = 0;
        int flag = nums[cnt++];
        for (int i = 1; i < length; i++) {
            if (nums[i] != flag) {
                nums[cnt++] = nums[i];
                flag = nums[i];
            }
        }
        return cnt;
    }
};

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(0);
    nums.push_back(0);
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(2);
    nums.push_back(3);
    nums.push_back(3);
    nums.push_back(4);
    int length = solution.removeDuplicates(nums);
    return 0;
}
