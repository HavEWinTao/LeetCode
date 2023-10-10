import java.util.*;

public class Solution {

    public int longestMountain(int[] arr) {
        int ans = 0;
        boolean asc = false;
        boolean desc = false;
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {//递减
                if (asc && (!desc)) {
                    desc = true;
                    ans = Math.max(ans, i - start + 1);
                } else if (asc && desc) {
                    ans = Math.max(ans, i - start + 1);
                } else {
                    start = i;
                    asc = false;
                    desc = false;
                }
            } else if (arr[i - 1] == arr[i]) {//相等
                start = i;
                asc = false;
                desc = false;
            } else {//递增
                if (!desc) {
                    asc = true;
                } else {
                    asc = true;
                    desc = false;
                    start = i - 1;
                }
            }
        }
        return ans;
    }
}