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
    ListNode *swapPairs(ListNode *head) {
        ListNode *ans = new ListNode(0, head);
        ListNode *p = ans->next;
        ListNode *index = ans;
        while (p != nullptr && p->next != nullptr) {
            ListNode *first = p;
            ListNode *second = p->next;
            first->next = second->next;
            second->next = first;
            index->next = second;
            index = index->next;
            index = index->next;
            p = p->next;
        }
        return ans->next;
    }
};

int main() {
    Solution solution;
    ListNode *head14 = new ListNode(4);
    ListNode *head13 = new ListNode(3, head14);
    ListNode *head12 = new ListNode(2, head13);
    ListNode *head = new ListNode(1, head12);
    ListNode *ans = solution.swapPairs(head14);
    return 0;
}