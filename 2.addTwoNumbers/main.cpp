#include <iostream>
using namespace std;

struct ListNode {
     int val;
     ListNode *next;

     ListNode() : val(0), next(nullptr) {}

     ListNode(int x) : val(x), next(nullptr) {}

     ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *ans = new ListNode;
        ListNode *tail = ans;
        int c = 0;
        while (l1 != nullptr && l2 != nullptr) {
            int temp = l1->val + l2->val + c;
            if (temp >= 10) {
                temp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            ListNode* next_node = new ListNode(temp);
            tail->next = next_node;
            tail = tail->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        while (l1 != nullptr) {
            int temp = l1->val + c;
            if (temp >= 10) {
                temp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            ListNode* next_node = new ListNode(temp);
            tail->next = next_node;
            tail = tail->next;
            l1 = l1->next;
        }
        while (l2 != nullptr) {
            int temp = l2->val + c;
            if (temp >= 10) {
                temp -= 10;
                c = 1;
            } else {
                c = 0;
            }
            ListNode *next_node = new ListNode(temp);
            tail->next = next_node;
            tail = tail->next;
            l2 = l2->next;
        }
        if (c==1){
            ListNode *next_node = new ListNode(c);
            tail->next = next_node;
            tail = tail->next;
        }
        ans = ans->next;
        return ans;
    }
};


int main() {
    ListNode l17(9, nullptr);
    ListNode l16(9, &l17);
    ListNode l15(9, &l16);
    ListNode l14(9, &l15);
    ListNode l13(9, &l14);
    ListNode l12(9,&l13);
    ListNode l1(9,&l12);
    ListNode l24(9, nullptr);
    ListNode l23(9, &l24);
    ListNode l22(9,&l23);
    ListNode l2(9,&l22);
    Solution solution;
    ListNode* ans = solution.addTwoNumbers(&l1,&l2);
    return 0;
}
