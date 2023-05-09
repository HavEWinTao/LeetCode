#include <iostream>
#include <vector>
using namespace std;

struct node {
    int state;
    char op;
};

class Solution {
private:
    string s;
    string p;
    vector<node> nodes;
    int nodes_num;
    int lens;
    int lenp;

    void makeNodes() {
        //1:正常字母 2:. 3:* 4:匹配成功
        for (int i = 0; i < lenp; i++) {
            if (p[i] >= 'a' && p[i] <= 'z') {
                nodes.push_back({1, p[i]});
            } else if (p[i] == '.') {
                nodes.push_back({2, '.'});
            } else if (p[i] == '*') {
                nodes_num = nodes.size();
                nodes[nodes_num - 1].state = 3;//设置状态点
            }
        }
        nodes_num = nodes.size();
    }

    bool judge(int index_s, int index_node) {
        if (index_node == nodes_num || index_s == lens) {
            if (index_s == lens && index_node == nodes_num) {
                return true;
            } else if (index_node < nodes_num) {//p里剩余*的情况
                if (nodes[index_node].state == 3) {
                    return judge(index_s, index_node + 1);
                } else {
                    return false;
                }
            } else {//p已经走完，但是s没走完
                return false;
            }

        }
        if (nodes[index_node].state == 1) {
            if (nodes[index_node].op == s[index_s]) {
                return judge(index_s + 1, index_node + 1);
            } else {
                return false;
            }
        } else if (nodes[index_node].state == 2) {
            return judge(index_s + 1, index_node + 1);
        } else if (nodes[index_node].state == 3) {
            if (nodes[index_node].op == s[index_s] || nodes[index_node].op == '.') {
                //匹配一个，不进入下一状态
                //匹配一个进入下一状态
                //不匹配直接进入下一状态
                return judge(index_s + 1, index_node) || judge(index_s + 1, index_node + 1) ||
                       judge(index_s, index_node + 1);
            } else {
                return judge(index_s, index_node + 1);
            }
        }
        return false;
    }

public:
    bool isMatch(string s, string p) {
        this->s = s;
        this->p = p;
        this->lens = s.length();
        this->lenp = p.length();
        makeNodes();
        bool ans = judge(0, 0);
        return ans;
    }
};

int main() {
    Solution solution;
    string s = "ab";
    string p = "ab";
    bool ans = solution.isMatch(s, p);
    return 0;
}
