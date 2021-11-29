#include <iostream>
using namespace std;

//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {

    }
};

int main() {
    Solution solution;
    ListNode l13(4);
    ListNode l12(2, &l13);
    ListNode l11(1, &l12);
    ListNode l23(4);
    ListNode l22(3, &l23);
    ListNode l21(1, &l22);
    ListNode *ans = solution.mergeTwoLists(&l11, &l21);
    return 0;
}
