import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num:nums1){
            set1.add(num);
        }
        for (int num:nums2){
            set2.add(num);
        }
        int ans = 0;
        boolean flag1 = false,flag2=false;
        for (int i=1;i<=9;i++){
            if (set1.contains(i) && set2.contains(i)){
                return i;
            }
            if (!flag1 && set1.contains(i)&& !set2.contains(i)){
                ans = ans*10 + i;
                flag1 = true;
            }
            if (!flag2 && !set1.contains(i)&& set2.contains(i)){
                ans = ans*10 + i;
                flag2 = true;
            }
        }
        return ans;
    }
}