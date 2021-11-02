#include <iostream>
#include <vector>
#include <set>
#include <map>
using namespace std;

class Solution {
public:
    int findMax(int a, int b, int c) {
        int temp = max(b, c);
        return max(a, temp);
    }

    int findMid(int a, int b, int c) {
        int temp_max = max(a, b);
        int temp_min = min(a, b);
        if (c >= temp_max) {
            return temp_max;
        } else if (c <= temp_min) {
            return temp_min;
        } else {
            return c;
        }
    }

    int findMin(int a, int b, int c) {
        int temp = min(b, c);
        return min(temp, a);
    }

    vector<int> filter(vector<int> nums) {
        map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            if (mp.find(nums[i]) != mp.end()) {
                if (mp[nums[i]] < 3) {
                    mp[nums[i]]++;
                }
            } else {
                mp.insert(make_pair(nums[i], 1));
            }
        }
        map<int, int>::iterator it;
        vector<int> ans;
        for (it = mp.begin(); it != mp.end(); it++) {
            while (it->second--) {
                ans.push_back(it->first);
            }
        }
        return ans;
    }

    vector<vector<int>> threeSum(vector<int> &nums) {
        vector<int> nums_filter = filter(nums);
        int size = nums_filter.size();
        map<int, int> mp;
        int (*table)[3001] = new int[3001][3001];
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                table[i][j] = nums_filter[i] + nums_filter[j];
            }
        }
        for (int i = 0; i < size; i++) {
            mp.insert(make_pair(nums_filter[i], i));
        }
        set<vector<int>> temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int need_num = -table[i][j];
                if (mp.find(need_num) != mp.end()) {
                    if (mp[need_num] != i && mp[need_num] != j) {
                        vector<int> oneOfAns = {findMax(nums_filter[i], nums_filter[j], need_num),
                                                findMid(nums_filter[i], nums_filter[j], need_num),
                                                findMin(nums_filter[i], nums_filter[j], need_num)};
                        temp.insert(oneOfAns);
                    }
                }
            }
        }
        vector<vector<int>> ans;
        set<vector<int>>::iterator it;
        for (it = temp.begin(); it != temp.end(); it++) {
            ans.push_back(*it);
        }
        delete[]table;
        return ans;
    }
};

int main() {
    Solution solution;
    vector<int> nums;
    nums.push_back(-1);
    nums.push_back(0);
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(-1);
    nums.push_back(-4);
    vector<vector<int>> ans = solution.threeSum(nums);
    return 0;
}
