//
// Created by ZSins7588 on 2021/2/24.
//

int count(int i) {
    int ans = 0;
    while (i != 0) {
        if (i % 2 == 1) ans++;
        i /= 2;
    }
    return ans;
}

class Solution {
public:
    vector <string> readBinaryWatch(int num) {

        vector<int> hour[4];
        hour[0].push_back(0);
        hour[1].push_back(1);
        hour[1].push_back(2);
        hour[2].push_back(3);
        hour[1].push_back(4);
        hour[2].push_back(5);
        hour[2].push_back(6);
        hour[3].push_back(7);
        hour[1].push_back(8);
        hour[2].push_back(9);
        hour[2].push_back(10);
        hour[3].push_back(11);

        vector<int> min[6];
        min[0].push_back(0);
        min[1].push_back(1);
        min[1].push_back(2);
        min[2].push_back(3);
        min[1].push_back(4);
        min[2].push_back(5);
        min[2].push_back(6);
        min[3].push_back(7);
        min[1].push_back(8);
        min[2].push_back(9);
        min[2].push_back(10);
        min[3].push_back(11);
        min[2].push_back(12);
        min[3].push_back(13);
        min[3].push_back(14);
        min[4].push_back(15);
        min[1].push_back(16);
        min[2].push_back(17);
        min[2].push_back(18);
        min[3].push_back(19);
        min[2].push_back(20);
        min[3].push_back(21);
        min[3].push_back(22);
        min[4].push_back(23);
        min[2].push_back(24);
        min[3].push_back(25);
        min[3].push_back(26);
        min[4].push_back(27);
        min[3].push_back(28);
        min[4].push_back(29);
        min[4].push_back(30);
        min[5].push_back(31);
        min[1].push_back(32);
        min[2].push_back(33);
        min[2].push_back(34);
        min[3].push_back(35);
        min[2].push_back(36);
        min[3].push_back(37);
        min[3].push_back(38);
        min[4].push_back(39);
        min[2].push_back(40);
        min[3].push_back(41);
        min[3].push_back(42);
        min[4].push_back(43);
        min[3].push_back(44);
        min[4].push_back(45);
        min[4].push_back(46);
        min[5].push_back(47);
        min[2].push_back(48);
        min[3].push_back(49);
        min[3].push_back(50);
        min[4].push_back(51);
        min[3].push_back(52);
        min[4].push_back(53);
        min[4].push_back(54);
        min[5].push_back(55);
        min[3].push_back(56);
        min[4].push_back(57);
        min[4].push_back(58);
        min[5].push_back(59);

        vector <string> ans;
        int hour_num = num > 3 ? 3 : num;
        int min_num = num - hour_num;
        string temp;
        while (min_num <= 5 && hour_num >= 0) {
            for (int i = 0; i < hour[hour_num].size(); i++) {
                for (int j = 0; j < min[min_num].size(); j++) {
                    temp = to_string(hour[hour_num][i]) + ":";
                    string str_min = to_string(min[min_num][j]);
                    if (str_min.length() == 1) {
                        str_min = "0" + str_min;
                    }
                    temp += str_min;
                    ans.push_back(temp);
                }
            }

            min_num++;
            hour_num--;
        }

        return ans;
    }
};