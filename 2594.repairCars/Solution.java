import java.util.*;

public class Solution {

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long l = 1;
        long r = (long) ranks[0] * cars * cars;
        while (l<r){
            long mid = (l+r)/2;
            if (fn(ranks,cars,mid)){
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    public boolean fn(int[] ranks,int cars,long time){
        long cnt = 0;
        for (int rank:ranks){
            cnt += (long) Math.sqrt((double) time /rank);
        }
        return cnt>=cars;
    }

    public long repairCars1(int[] ranks, int cars) {
        int n = ranks.length;
        // time r n
        PriorityQueue<Long[]> heap = new PriorityQueue<>(((o1, o2) -> {
            long time1 =  o1[1]*(o1[2]+1)*(o1[2]+1);
            long time2 = o2[1]*(o2[2]+1)*(o2[2]+1);
            return Long.compare(time1,time2);
        }));
        for (int rank : ranks) {
            heap.add(new Long[]{0L, (long) rank, 0L});
        }
        while (cars-->0){
            Long[] top = heap.poll();
            top[2] += 1;
            top[0] = top[1]*top[2]*top[2];
            heap.add(top);
        }
        return heap.stream().map(o -> o[0]).max(Long::compareTo).get();
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int[] ranks = new int[]{4,2,3,1};
            int cars = 10;
            long ans = solution.repairCars(ranks, cars);
            System.out.println(ans);
        }

    }
}