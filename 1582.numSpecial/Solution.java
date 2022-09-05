import java.util.*;

public class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] list1 = new int[m];
        for (int i = 0; i < m; i++) {
            list1[i] = -1;
        }
        int[] list2 = new int[n];
        for (int i = 0; i < n; i++) {
            list2[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (flag) {
                        list1[i] = j;
                        flag = false;
                    } else {
                        list1[i] = -1;
                        break;
                    }
                }
                if (!flag) {

                }
            }
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (mat[j][i] == 1) {
                    if (flag) {
                        list2[i] = j;
                        flag = false;
                    } else {
                        list2[i] = -1;
                        break;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int index = list1[i];
            if (index != -1) {
                if (list2[index] == i) {
                    ans++;
                }
            }
        }
        return ans;
    }
}