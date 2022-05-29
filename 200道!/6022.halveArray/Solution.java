import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int halveArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        double sum = 0;
        double[] temp = new double[length];
        int index1 = length - 1;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            temp[i] = nums[i];
        }
        List<Double> compare = new ArrayList<>();
        compare.add(0.0);
        int index2 = 0;
        int length2 = 0;
        int ans = 0;
        double subSum = 0;
        while (subSum < (sum / 2)) {
            double half;
            if (temp[index1] > compare.get(index2)) {
                half = temp[index1] / 2;
                index1--;
            } else {
                half = compare.get(index2) / 2;
                index2++;
            }
            subSum += half;
            compare.set(length2, half);
            length2++;
            compare.add(0.0);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = new int[]{58, 23};
        int[] nums = new int[]{5, 19, 8, 1};
        System.out.println(solution.halveArray(nums));
        System.out.println(Arrays.toString(nums));
    }
}
