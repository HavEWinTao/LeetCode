public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int num1 = find((m + n + 1) / 2, nums1, 0, m - 1, nums2, 0, n - 1);
        int num2 = find((m + n) / 2 + 1, nums1, 0, m - 1, nums2, 0, n - 1);
        return (double) (num1 + num2) / 2;
    }

    private int find(int n, int[] nums1, int l1, int r1, int[] nums2, int l2, int r2) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        if (len1 == 0) return nums2[l2 + n - 1];
        if (len2 == 0) return nums1[l1 + n - 1];
        if (n == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }
        int mid1 = l1 + Math.min(n / 2, len1) - 1;
        int mid2 = l1 + Math.min(n / 2, len2) - 1;
        if (nums1[mid1] > nums2[mid2]) return find(n - (mid2 - l2 + 1), nums1, l1, r1, nums2, mid2 + 1, r2);
        else return find(n - (mid1 - l1 + 1), nums1, mid1 + 1, r1, nums2, l2, r2);
    }
}