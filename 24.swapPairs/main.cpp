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
    ListNode* swapPairs(ListNode* head) {

    }
};

int main() {
    Solution solution;
    ListNode *head14 = new ListNode(4);
    ListNode *head13 = new ListNode(3, head14);
    ListNode *head12 = new ListNode(2, head13);
    ListNode *head = new ListNode(1, head12);
    ListNode *ans = solution.swapPairs(head);
    return 0;
}