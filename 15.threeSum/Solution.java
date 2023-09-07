import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            if (nums[i]>0) break;
            int target = -nums[i];
            int j = i+1;
            int k = n-1;
            while (j<k){
                if (j!=i+1 && nums[j]==nums[j-1]) {
                    j++;
                    continue;
                }
                if (nums[j]+nums[k]==target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    continue;
                }
                if (nums[j]+nums[k]<target){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Main();
        {
            int[] nums = new int[]{-1,0,1,2,-1,4};
            List<List<Integer>> ans = solution.threeSum(nums);
            System.out.println(ans);
        }
    }
}