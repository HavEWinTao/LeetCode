#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target) {
        int size = nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        for (int i = 0; i < size - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //没什么必要
            //if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
            //    break;
            //}
            for (int j = i + 1; j < size - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                //    break;
                //}
                int left = j + 1;
                int right = size - 1;
                while (left < right) {
                    if (nums[i] + nums[j] < target - (nums[left] + nums[right])) {
                        left++;//不相等不需要做去重操作，把while放到相等里
                    } else if (nums[i] + nums[j] > target - (nums[left] + nums[right])) {
                        right--;
                    } else {
                        vector<int> temp = {nums[i], nums[j], nums[left], nums[right]};
                        ans.push_back(temp);
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;
                        while (right > left && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(-2);
    nums.push_back(-1);
    nums.push_back(-1);
    nums.push_back(1);
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(2);
    vector<vector<int>> ans = solution.fourSum(nums, 0);
    return 0;
}
