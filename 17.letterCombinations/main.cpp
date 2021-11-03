#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        vector<string> character;
        character.emplace_back("");
        character.emplace_back("");
        character.emplace_back("abc");
        character.emplace_back("def");
        character.emplace_back("ghi");
        character.emplace_back("jkl");
        character.emplace_back("mno");
        character.emplace_back("pqrs");
        character.emplace_back("tuv");
        character.emplace_back("wxyz");
        for (char digit: digits) {
            vector<string> temp;
            if (ans.empty()) {
                for (int k = 0; k < character[digit - '0'].size(); k++) {
                    string temp_str = character[digit - '0'].substr(k, 1);
                    temp.push_back(temp_str);
                }
            }
            for (auto &an: ans) {
                for (char k: character[digit - '0']) {
                    string temp_str = an + k;
                    temp.push_back(temp_str);
                }
            }
            ans = temp;
        }
        return ans;
    }
};

int main() {
    Solution solution;
    string digits = "2";
    vector<string> ans = solution.letterCombinations(digits);
    return 0;
}
