public class Solution {
    public void sortColors(int[] nums) {
        int index0 = 0;
        int index2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i == index0) {
                    index0++;
                } else {
                    int temp = nums[index0];
                    nums[index0] = nums[i];
                    nums[i] = temp;
                    index0++;
                    i--;
                }
            } else if (nums[i] == 2) {
                if (i <= index2) {
                    int temp = nums[index2];
                    nums[index2] = nums[i];
                    nums[i] = temp;
                    index2--;
                    i--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println("暂停");
    }
}
