#include <iostream>
#include <vector>
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
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode *ans = new ListNode(0);
        ListNode *rear = ans;
        while (l1 && l2) {
            if (l1->val < l2->val) {
                ListNode *temp = new ListNode(l1->val);
                rear->next = temp;
                rear = rear->next;
                l1 = l1->next;
            } else {
                ListNode *temp = new ListNode(l2->val);
                rear->next = temp;
                rear = rear->next;
                l2 = l2->next;
            }
        }
        if (l1) {
            rear->next = l1;
        }
        if (l2) {
            rear->next = l2;
        }
        return ans->next;
    }

    vector<ListNode *> recursion(vector<ListNode *> &lists) {
        int size = lists.size();
        vector<ListNode *> ans;
        for (int i = 0; i < size / 2; i++) {
            ListNode *temp = mergeTwoLists(lists[i], lists[size - i - 1]);
            ans.push_back(temp);
        }
        if ((size % 2) == 1) {
            ans.push_back(lists[size / 2]);
        }
        return ans;
    }


    ListNode *mergeKLists(vector<ListNode *> &lists) {
        int size = lists.size();
        if (size == 0) {
            return NULL;
        }
        ListNode *ans;
        vector<ListNode *> temp = lists;
        while (true) {
            temp = recursion(temp);
            if (temp.size() == 1) {
                ans = temp[0];
                break;
            }
        }
        return ans;
    }
};

int main() {
    Solution solution;
    ListNode l13(5);
    ListNode l12(4, &l13);
    ListNode *l11 = new ListNode(1, &l12);
    ListNode l23(4);
    ListNode l22(3, &l23);
    ListNode *l21 = new ListNode(1, &l22);
    ListNode l32(6);
    ListNode *l31 = new ListNode(2, &l32);
    vector<ListNode *> lists;
    lists.push_back(l11);
    lists.push_back(l21);
    lists.push_back(l31);
    ListNode *ans = solution.mergeKLists(lists);
    return 0;
}
