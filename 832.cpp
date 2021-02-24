//
// Created by ZSins7588 on 2021/2/24.
//

class Solution {
public:
    vector <vector<int>> flipAndInvertImage(vector <vector<int>> &A) {
        int n = A.size();//方阵的阶
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (A[i][left] == A[i][right]) {
                    A[i][left] ^= 1;
                    A[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }
};
