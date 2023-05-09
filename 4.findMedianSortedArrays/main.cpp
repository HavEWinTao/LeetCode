#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
        int size1 = nums1.size();
        int size2 = nums2.size();
        double ans = 0.0;
        int index1 = 0, index2 = 0;
        for (int i = 0; i < (size1 + size2) / 2; i++) {
            if (index1 >= size1) {
                ans = nums2[index2];
                index2++;
            } else if (index2 >= size2) {
                ans = nums1[index1];
                index1++;
            } else if (nums1[index1] <= nums2[index2]) {
                ans = nums1[index1];
                index1++;
            } else {
                ans = nums2[index2];
                index2++;
            }
        }
        if ((size1 + size2) % 2 == 0) {
            if (index1 == size1) {
                ans += nums2[index2];
            } else if (index2 == size2) {
                ans += nums1[index1];
            } else if (nums1[index1] > nums2[index2]) {
                ans += nums2[index2];
            } else {
                ans += nums1[index1];
            }
            ans /= 2;
        } else {
            if (index1 == size1) {
                ans = nums2[index2];
            } else if (index2 == size2) {
                ans = nums1[index1];
            } else if (nums1[index1] > nums2[index2]) {
                ans = nums2[index2];
            } else {
                ans = nums1[index1];
            }
        }
        return ans;
    }
};

int main() {
    vector<int> nums1;
    nums1.push_back(1);
    //nums1.push_back(2);
    vector<int> nums2;
    nums2.push_back(2);
    nums2.push_back(3);
    nums2.push_back(4);
    Solution solution;
    double ans = solution.findMedianSortedArrays(nums1, nums2);
    return 0;
}
