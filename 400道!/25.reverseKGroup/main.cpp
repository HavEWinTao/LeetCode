#include <iostream>
#include <queue>
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
    ListNode *reverseKGroup(ListNode *head, int k) {
        ListNode *ans = new ListNode(0, head);
        ListNode *p = ans->next;
        ListNode *index = ans; //该组前一节点
        while (p != nullptr) {
            queue<ListNode *> que;
            for (int i = 0; i < k; i++) {
                que.push(p);
                p = p->next;
                if (p == nullptr) {
                    break;
                }
            }
            if (que.size() < k) {
                break;
            }
            ListNode *temp = p;
            while (!que.empty()) {
                ListNode *now = que.front();
                que.pop();
                now->next = temp;
                temp = now;
            }
            index->next = temp;
            for (int i = 0; i < k; i++) {
                index = index->next;
            }
        }
        return ans->next;
    }
};

int main() {
    Solution solution;
    ListNode *head15 = new ListNode(5);
    ListNode *head14 = new ListNode(4, head15);
    ListNode *head13 = new ListNode(3, head14);
    ListNode *head12 = new ListNode(2, head13);
    ListNode *head = new ListNode(1, head12);
    ListNode *ans = solution.reverseKGroup(head, 1);
    return 0;
}