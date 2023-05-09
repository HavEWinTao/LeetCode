public class Solution {
    int[] nums;

    int n;

    //假设所有输入数组都可以得到满足题目要求的结果
    public void wiggleSort(int[] _nums) {
        nums = _nums;
        n = nums.length;
        //找中位数
        int x = qselect(0, n - 1, n + 1 >> 1);
        int l = 0, r = n - 1, loc = 0;
        //将数组分为小于x 等于x 大于x的三个部分
        while (loc <= r) {
            if (nums[loc] < x) swap(loc++, l++);
            else if (nums[loc] > x) swap(loc, r--);
            else loc++;
        }
        int[] clone = nums.clone();
        int idx = 1;
        loc = n - 1;
        //放奇数下标，因为奇数位置的数字大，所以从右往左放
        while (idx < n) {
            nums[idx] = clone[loc--];
            idx += 2;
        }
        idx = 0;
        //放偶数位置的下标
        while (idx < n) {
            nums[idx] = clone[loc--];
            idx += 2;
        }
    }

    private int qselect(int l, int r, int k) {
        if (l == r) return nums[l];
        int x = nums[l + r >> 1];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        int cnt = j - l + 1;
        if (k <= cnt) {
            return qselect(l, j, k);
        } else {
            return qselect(j + 1, r, k - cnt);
        }
    }

    private void swap(int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 1};
        //1, 3, 2, 2, 3, 1};
        //1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums);
        System.out.println("暂停");
    }
}
