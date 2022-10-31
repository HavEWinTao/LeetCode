#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:

    int threeSumClosest(vector<int> &nums, int target) {
        int size = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 1e4;
        for (int i = 0; i < size; i++) {
            //保证i和上一次的不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = size - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == target) {
                    return target;
                }
                if (abs(temp - target) < abs(ans - target)) {
                    ans = temp;
                }
                if (temp > target) {
                    int temp_k = k - 1;
                    while (temp_k > j && nums[temp_k] == nums[k]) {
                        temp_k--;
                    }
                    k = temp_k;
                }
                if (temp < target) {
                    int temp_j = j + 1;
                    while (temp_j < k && nums[temp_j] == nums[j]) {
                        temp_j++;
                    }
                    j = temp_j;
                }
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(-1);
    nums.push_back(2);
    nums.push_back(1);
    nums.push_back(-4);
    int ans = solution.threeSumClosest(nums, 1);
    return 0;
}
