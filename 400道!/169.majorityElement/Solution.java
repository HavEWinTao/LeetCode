public class Solution {

    //HashSet不写了

    //Boyer-Moore 投票算法
    //因为这个多数元素在数组中出现的次数大于n/2,n一定是出现次数最多并且多于一半的
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{7, 7, 2, 3, 4};
        System.out.println(solution.majorityElement(nums));
    }
}
