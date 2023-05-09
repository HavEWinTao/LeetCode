public class Solution {
    //1.nums1[i] > nums1[i-1]且nums2[i] > nums2[i-1]
    //2.nums1[i] > nums2[i-1]且nums2[i] > nums1[i-1]
    //只满足1、只满足2、1和2同时满足
    //分三种情况进行讨论
    //求解每一个状态都只与前一个状态有关，可以用「滚动数组」的方法来进行空间优化
    //i=0时，无论是否交换都为合法状态
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            boolean flag1 = (nums1[i] > nums1[i - 1]) && (nums2[i] > nums2[i - 1]);
            boolean flag2 = (nums1[i] > nums2[i - 1]) && (nums2[i] > nums1[i - 1]);
            if (flag1 && flag2) {
                a = Math.min(at, bt);
                b = Math.min(bt, at) + 1;
            } else if (flag1) {
                a = at;
                b = bt + 1;
            } else if (flag2) {
                a = bt;
                b = at + 1;
            }
        }
        return Math.min(a, b);
    }
}