import java.util.*;

public class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] cnt = new int[k];

        TreeSet<Integer> isAvailable = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            isAvailable.add(i);
        }

        //第一个元素是结束时间，第二个是编号
        PriorityQueue<int[]> isBusy = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < arrival.length; i++) {
            int current = arrival[i];

            while (!isBusy.isEmpty() && isBusy.peek()[0] <= current) {
                isAvailable.add(isBusy.poll()[1]);
            }

            if (isAvailable.isEmpty()) {
                continue;
            }
            //一个环状，这回理解了
            Integer serverIndex = isAvailable.ceiling(i % k);
            //如果找不到就是最小的作为可用服务器
            if (serverIndex == null) {
                serverIndex = isAvailable.first();
            }
            //因为已经判断不为空了，所以一定存在
            isAvailable.remove(serverIndex);
            isBusy.offer(new int[]{current + load[i], serverIndex});
            cnt[serverIndex]++;
        }
        List<Integer> ans = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < k; i++) {
            if (cnt[i] == max) {
                ans.add(i);
            }
            if (cnt[i] > max) {
                max = cnt[i];
                ans.clear();
                ans.add(i);
            }
        }
        return ans;
    }
}
