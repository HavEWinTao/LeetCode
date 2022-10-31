import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //使用小顶堆，只保留k个最大的，空间较优，数据不需要一次性读入内存
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < len; i++) {
            Integer top = minHeap.peek();
            if (nums[i] > top) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
