import java.util.*;

public class distance {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, List<Long>> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
            List<Long> preSum = sum.getOrDefault(nums[i], new ArrayList<>());
            long total = preSum.isEmpty() ? 0 : preSum.get(preSum.size() - 1);
            preSum.add(total + i);
            sum.put(nums[i], preSum);
        }
        long[] ans = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            long temp = 0;
            int index = Collections.binarySearch(list, i);
            List<Long> preSum = sum.get(nums[i]);
            temp += preSum.get(preSum.size() - 1) - preSum.get(index) - (long) i * (preSum.size() - index - 1);
            temp += (long) i * (index + 1) - preSum.get(index);
            ans[i] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 1, 1, 2};
        distance solution = new distance();
        System.out.println(Arrays.toString(solution.distance(nums)));
    }
}
