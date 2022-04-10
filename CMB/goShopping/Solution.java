package goShopping;

import java.util.Arrays;

//商品促销活动——不会
public class Solution {
    public int goShopping(int[] priceA, int[] priceB) {
        Arrays.sort(priceA);
        Arrays.sort(priceB);
        int ans = 0;
        int num = priceA.length - 1;
        while (num >= 2) {
            int sumA = priceA[num] + priceA[num - 1] + priceA[num - 2];
            sumA = (int) (sumA * 0.7);
            int sumB = priceB[num] + priceB[num - 1];
            num -= 3;
            ans += Math.min(sumA, sumB);
        }
        while (num > 0) {
            ans += Math.min(priceA[num], priceB[num]);
            num--;
        }
        return ans;
    }
}
