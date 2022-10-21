public class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
            int temp = 0;
            while (num!=0){
                temp = temp*10+num%10;
                num/=10;
            }
            set.add(temp);
        }
        return set.size();
    }
}