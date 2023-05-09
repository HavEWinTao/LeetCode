public class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }
        for (int i = num; i > 0; i--) {
            int k = i;
            int temp1 = 0;
            int temp2 = i;
            while (temp2 != 0) {
                temp1 = temp1 * 10 + temp2 % 10;
                temp2 /= 10;
            }
            k += temp1;
            if (k == num) {
                return true;
            }
        }
        return false;
    }
}