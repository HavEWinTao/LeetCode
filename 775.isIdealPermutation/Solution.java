public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        int cnt1 = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt1++;
            }
            index.put(nums[i], i);
        }
        index.put(nums[n - 1], n - 1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt2 = 0;


        for (int i = n - 1; i >= 0; i--) {
            Integer bound = map.floorKey(nums[i]);
            if (bound == null) {
                map.put(nums[i], 0);
            } else {
                if (index.get(bound) != i + 1) {
                    return false;
                }
                int cnt = map.get(bound) + 1;
                map.put(nums[i], cnt);
                cnt2 += cnt;
            }
        }
        return cnt1 == cnt2;
    }
}