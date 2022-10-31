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
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        int length = 0;
        ListNode *temp = head;
        while (temp != nullptr) {
            length++;
            temp = temp->next;
        }
        temp = head;
        int index = length - n;
        if (index == 0) {
            return head->next;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp->next;
        }
        if (temp->next == nullptr) {
            return nullptr;
        }
        temp->next = temp->next->next;
        return head;
    }
};

int main() {
    Solution solution;
    ListNode head5(5);
    ListNode head4(4, &head5);
    ListNode head3(3, &head4);
    ListNode head2(2, &head3);
    ListNode head(1, &head2);
    ListNode *ans = solution.removeNthFromEnd(&head4, 2);
    return 0;
}
