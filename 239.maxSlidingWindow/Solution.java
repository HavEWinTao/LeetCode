import java.util.PriorityQueue;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        PriorityQueue<Integer[]> heap = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2[0],o1[0])));
        for (int i=0;i<k;i++) heap.offer(new Integer[]{nums[i],i});
        ans[0] = heap.peek()[0];
        for (int i=1;i<=n-k;i++){
            int idx = i+k-1;
            heap.offer(new Integer[]{nums[idx],idx});
            while (heap.peek()[1]<i) heap.poll();
            ans[i] = heap.peek()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
            int[] ans = solution.maxSlidingWindow(nums, 3);
            System.out.println(Arrays.toString(ans));
        }
    }
}