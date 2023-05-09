public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] nums = new int[1001];
        for (int num : target) {
            nums[num]++;
        }
        for (int num : arr) {
            if (nums[num] == 0) {
                return false;
            }
            nums[num]--;
        }
        return true;
    }
}
