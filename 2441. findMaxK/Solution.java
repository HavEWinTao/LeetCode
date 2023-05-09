public class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                set.add(num);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            if (num < 0) {
                break;
            }
            if (set.contains(-num)) {
                return num;
            }
        }
        return -1;
    }
}