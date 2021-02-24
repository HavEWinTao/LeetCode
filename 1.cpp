//
// Created by ZSins7588 on 2021/2/24.
//

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        int size = nums.size();
        map<int, int> hash;
        map<int, int>::iterator it;
        for (int i = 0; i < size; i++) {
            it = hash.find(target - nums[i]);
            if (it != hash.end()) {
                return {i, it->second};
            }
            hash.insert(pair<int, int>(nums[i], i));
        }
        return {};
    }
};