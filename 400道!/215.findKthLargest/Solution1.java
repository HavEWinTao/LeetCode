import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution1 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        //快速选择
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);//左区间都比a[q]小，右区间都比a[q]大
        if (q == index) {//已经找到了就直接返回a[q]
            return a[q];
        } else {
            if (q < index) {//q比index小，找右区间
                return quickSelect(a, q + 1, r, index);
            } else {//q比index大，找左区间
                return quickSelect(a, l, q - 1, index);
            }
        }
    }

    private int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;//随机在[l,r]区间内找一个下标
        swap(a, i, r);//把这个元素放到最右面
        return partition(a, l, r);
    }

    //分治
    private int partition(int[] a, int l, int r) {
        int x = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);//再交换回来，现在就满足了在[l,r]区间内，以i+1分割了大小
        return i + 1;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
