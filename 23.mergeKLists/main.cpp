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
    ListNode *mergeKLists(vector<ListNode *> &lists) {

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
