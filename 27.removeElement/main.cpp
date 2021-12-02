#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int removeElement(vector<int> &nums, int val) {
        int size = nums.size();
        int index = 0;
        while (index < size) {
            if (nums[index] == val) {
                nums[index] = nums[--size];
            } else { //用这样的逻辑防止换到该位置的数的值还为value
                index++;
            }
        }
        return index;
    }
};

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(0);
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(2);
    nums.push_back(3);
    nums.push_back(0);
    nums.push_back(4);
    nums.push_back(2);
    int length = solution.removeElement(nums, 2);
    return 0;
}
