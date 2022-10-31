import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int length = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                ans.clear();
                min = diff;
                List<Integer> temp = Arrays.stream(new int[]{arr[i], arr[i + 1]}).boxed().toList();
                ans.add(temp);
            } else if (diff == min) {
                List<Integer> temp = Arrays.stream(new int[]{arr[i], arr[i + 1]}).boxed().toList();
                ans.add(temp);
            }
        }
        return ans;
    }
}
