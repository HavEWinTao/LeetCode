public class NumArray {
    //TLE
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans = ans + nums[i];
        }
        return ans;
    }
}
