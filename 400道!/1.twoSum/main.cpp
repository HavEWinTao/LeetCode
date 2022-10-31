#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <unordered_map>

using namespace std;

bool cmpbyValue(pair<int, int> &lhs, pair<int, int> &rhs) {
    return lhs.second < rhs.second;
}

/*
struct cmpbyValue {
    bool operator()(const pair<int, int> &lhs, const pair<int, int> &rhs) {
        return lhs.second < rhs.second;
    }
};
*/

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        vector<pair<int,int>> temp;
        for (int i = 0; i < nums.size(); i++) {
            pair<int,int> insert_pair = {i,nums[i]};
            temp.push_back(insert_pair);
        }
        sort(temp.begin(), temp.end(),cmpbyValue);
        int begin=0,end=nums.size()-1;
        while (begin != end) {
            if (temp[begin].second + temp[end].second > target) {
                end--;
            } else if (temp[begin].second + temp[end].second < target) {
                begin++;
            } else {
                return {temp[begin].first, temp[end].first};
            }
        }
        return {};
    }
};

class BestSolution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> hashtable;
        for (int i = 0; i < nums.size(); i++) {
            unordered_map<int, int>::iterator it = hashtable.find(target - nums[i]);
            if (it != hashtable.end()) {
                return {it->second, i};
            }
            hashtable[nums[i]] = i;
        }
        return {};
    }
};

int main() {
    vector<int> nums;
    nums.push_back(2);
    nums.push_back(11);
    nums.push_back(7);
    nums.push_back(15);
    Solution solution;
    vector<int> ans;
    ans = solution.twoSum(nums, 9);
    BestSolution bestSolution;
    ans = bestSolution.twoSum(nums,9);
    return 0;
}
