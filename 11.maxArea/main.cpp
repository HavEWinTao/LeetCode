#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int> &height) {
        int size = height.size();
        int left_index = 0;
        int right_index = size - 1;
        int ans = 0;
        while (left_index < right_index) {
            int temp = (right_index - left_index) * min(height[left_index], height[right_index]);
            if (temp > ans) {
                ans = temp;
            }
            if (height[left_index] < height[right_index]) {
                left_index++;
            } else {
                right_index--;
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    vector<int> height;
    height.push_back(1);
    height.push_back(8);
    height.push_back(6);
    height.push_back(2);
    height.push_back(5);
    height.push_back(4);
    height.push_back(8);
    height.push_back(3);
    height.push_back(7);
    int ans = solution.maxArea(height);
    return 0;
}
