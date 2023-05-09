public class Solution {

    public int magicalString(int n) {
        int[] str = new int[100001];
        str[0] = 1;
        str[1] = 2;
        int i = 1, j = 1;
        int flag = 1;
        int ans = 1;
        while (i < n) {
            int num = str[j];
            for (int k = 0; k < num && i < n; k++) {
                str[i] = 1 + flag;
                if (str[i] == 1) {
                    ans++;
                }
                i++;
            }
            flag = flag == 1 ? 0 : 1;
            j++;
        }
        return ans;
    }
}